package com.ams.controller.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evan on 2016/3/15.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Page<UserInfo> page = new Page<UserInfo>();
        page.setCurrentPage(1);
        page.setTotalPage(10);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("age", 21);
        page = this.userService.queryList();
        model.addAttribute("page", page);
        model.addAttribute("test", "112233");
        return "login/list";
    }

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        UserInfo user = new UserInfo();
        user.setUserName("Evan");
        user.setPassword("123445");
        this.userService.saveUser(user);
        return "user/list";
    }
}
