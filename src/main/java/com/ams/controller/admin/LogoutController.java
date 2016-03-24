package com.ams.controller.admin;

import com.ams.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注销控制器.
 * Created by Evan on 2016/3/21.
 */
@Controller
public class LogoutController extends BaseController {


    @RequestMapping(value = "/member/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = getSession(request);
        session.removeAttribute(Constant.SESSION_LOGIN_USER);
        return "index";
    }
}
