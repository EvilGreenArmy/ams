package com.ams.controller.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
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

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value="currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value="pageSize", defaultValue = "10") Integer pageSize) {
        Page<UserInfo> page = new Page<UserInfo>();
        page.setCurrentPage(currentPage);
        page.setTotalPage(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        page = this.userService.queryList(paramMap);
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
                      @RequestParam("acctName") String acctName, @RequestParam("id") Integer id) {
        UserInfo user = new UserInfo();
        user.setAcctName(acctName);
        user.setId(id);
        boolean exist = this.userService.checkAcctName(user);
        StringBuffer sb = new StringBuffer("{");
        if(exist) {
            sb.append("\"state\":\"1\"");
        } else {
            sb.append("\"state\":\"0\"");
        }
        sb.append("}");
        return sb.toString();
    }
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam("id") Integer id) {
        UserInfo user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
     public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                        @ModelAttribute UserInfo user) {
        this.userService.updateUser(user);
        return "redirect:/user/list.do";
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam("id") Integer[] ids) {
        this.userService.deleteUser(ids);
        return "redirect:/user/list.do";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
