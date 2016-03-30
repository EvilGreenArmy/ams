package com.ams.controller.admin;

import com.ams.entities.admin.RoleInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evan on 2016/3/30.
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<RoleInfo> page = new Page<RoleInfo>();
        page.setCurrentPage(currentPage);
        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        page = this.roleService.queryList(paramMap);
        model.addAttribute("page", page);
        return "role/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        RoleInfo role = new RoleInfo();
        model.addAttribute("role", role);
        return "role/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @ModelAttribute RoleInfo role) {
        this.roleService.saveRole(role);
        return "redirect:/role/list.do";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam("id") Integer id) {
        RoleInfo role = this.roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "role/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute RoleInfo role) {
        this.roleService.updateRole(role);
        return "redirect:/role/list.do";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam("id") Integer[] ids) {
        this.roleService.deleteRole(ids);
        return "redirect:/role/list.do";
    }
}
