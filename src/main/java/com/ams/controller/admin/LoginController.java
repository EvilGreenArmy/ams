package com.ams.controller.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.service.admin.MessageService;
import com.ams.service.admin.SourceService;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器.
 * Created by Evan on 2016/3/21.
 */
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private SourceService sourceService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(String userName, String password, HttpServletRequest request, HttpServletResponse response,
                        Model model) {
        return "login/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doLogin(String userName, String password, HttpServletRequest request, HttpServletResponse response,
                          Model model) {
        UserInfo user = this.userService.getUserByLogin(userName, password);
        if (user != null) {
            if (Constant.ACTIVE_STATUS.equalsIgnoreCase(user.getStatus())) {
                HttpSession session = getSession(request);
                session.setAttribute(Constant.SESSION_LOGIN_USER, user);
                StringBuffer basePath = new StringBuffer();
                basePath.append(request.getScheme()).append("://");
                basePath.append(request.getServerName()).append(":");
                basePath.append(request.getServerPort()).append(request.getContextPath());
                session.setAttribute(Constant.BASE_PATH, basePath.toString());
                return "redirect:/admin/main.do";
            } else {
                model.addAttribute("errMsg", "当前用户已被禁止登录");
                return "login/login";
            }
        } else {
            model.addAttribute("errMsg", "用户名或密码错误");
            return "login/login";
        }

    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main(HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        HttpSession session = getSession(request);
        UserInfo user = (UserInfo)session.getAttribute(Constant.SESSION_LOGIN_USER);
        //一级菜单
        model.addAttribute("parentList", sourceService.getParentSource(user));
        //二级菜单
        model.addAttribute("menuList", sourceService.getChildrenSource(user));
        //未读消息数量
        model.addAttribute("UnreadMessages", messageService.queryUnreadMessage(user.getId()));
        return "base.definition";
    }
    @RequestMapping(value = "modifyPassword", method = RequestMethod.GET)
    public String initModifyPassword(HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        return "user/password";
    }
    @RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
    public @ResponseBody String modifyPassword(HttpServletRequest request, HttpServletResponse response,
                                     Model model, @RequestParam("oldPassword") String oldPassword,
                                     @RequestParam("newPassword") String newPassword,
                                     @RequestParam("newPasswordReply") String newPasswordReply) {

        UserInfo user = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        if(!this.userService.encodePassword(oldPassword).equals(user.getPassword())) {
            return "{\"state\":\"0\", \"errMsg\":\"原密码不正确!\"}";
        }
        if(!newPassword.equals(newPasswordReply)) {
            return "{\"state\":\"0\", \"errMsg\":\"两次密码不一致!\"}";
        }
        newPassword = this.userService.encodePassword(newPassword);
        user.setPassword(newPassword);
        this.userService.modifyPassword(user);
        getSession(request).setAttribute(Constant.SESSION_LOGIN_USER, user);
        return "{\"state\":\"1\", \"errMsg\":\"\"}";
    }
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String initRegister(HttpServletRequest request, HttpServletResponse response,
                        Model model) {
        HttpSession session = getSession(request);
        StringBuffer basePath = new StringBuffer();
        basePath.append(request.getScheme()).append("://");
        basePath.append(request.getServerName()).append(":");
        basePath.append(request.getServerPort()).append(request.getContextPath());
        session.setAttribute(Constant.BASE_PATH, basePath.toString());
        return "login/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response,
                               Model model, UserInfo userInfo) {
        userInfo.setStatus(Constant.ACTIVE_STATUS);
        this.userService.saveUser(userInfo);
        return "login/login";
    }

    @RequestMapping(value = "productDetail", method = RequestMethod.GET)
    public String product(HttpServletRequest request, HttpServletResponse response,
                               Model model) {
        return "product/frontDetail";
    }
}
