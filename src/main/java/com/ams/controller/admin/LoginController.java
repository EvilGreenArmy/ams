package com.ams.controller.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "base.definition";
    }
}
