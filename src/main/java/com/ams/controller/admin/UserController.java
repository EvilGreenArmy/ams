package com.ams.controller.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        page = this.userService.queryList();
        model.addAttribute("page", page);
        return "user/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        UserInfo user = new UserInfo();
        model.addAttribute("user", user);
        return "user/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @ModelAttribute UserInfo user) {
        this.userService.saveUser(user);
        return "redirect:/user/list.do";
    }
    @RequestMapping(value = "checkAcctName", method = RequestMethod.GET)
    public @ResponseBody String checkAcctName(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @RequestParam("acctName") String acctName) {
        boolean exist = this.userService.checkAcctName(acctName);
        StringBuffer sb = new StringBuffer("{");
        if(exist) {
            sb.append("\"state\":\"1\"");
        } else {
            sb.append("\"state\":\"0\"");
        }
        sb.append("}");
        return sb.toString();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
