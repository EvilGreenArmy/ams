package com.ams.controller.admin;

import com.ams.entities.UserInfo;
import com.ams.service.UserService;
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
    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(String userName, String password,HttpServletRequest request, HttpServletResponse response,
                          Model model){
            return "login/login";
        }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String doLogin(String userName, String password,HttpServletRequest request, HttpServletResponse response,
                            Model model){
        UserInfo user = userService.getUserByLogin(userName, password);
        if (user != null) {
            HttpSession session =getSession(request);
            session.setAttribute(Constant.SESSION_LOGIN_USER, user);
            return "redirect:/member/index.do";
        } else {
            model.addAttribute("info", "用户名或密码错误!");
            return "index";
        }
    }

}
