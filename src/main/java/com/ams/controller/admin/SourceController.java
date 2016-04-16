package com.ams.controller.admin;

import com.ams.entities.admin.RoleInfo;
import com.ams.entities.admin.SourceInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.RoleService;
import com.ams.service.admin.SourceService;
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
@RequestMapping("source")
public class SourceController extends BaseController {
    @Autowired
    private SourceService sourceService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam(value="name", required = false) String name,
                       @RequestParam(value="code", required = false) String code) {
        Page<SourceInfo> page = new Page<SourceInfo>();
        page.setCurrentPage(currentPage);
        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("name", name);
        paramMap.put("code", code);
        page = this.sourceService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);
        return "source/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        SourceInfo source = new SourceInfo();
        model.addAttribute("source", source);
        return "source/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @ModelAttribute SourceInfo source) {
        this.sourceService.saveSource(source);
        return "redirect:/source/list.do";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                           @RequestParam("id") Integer id) {
        SourceInfo source = this.sourceService.getSourceById(id);
        model.addAttribute("source", source);
        return "source/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute SourceInfo source) {
        this.sourceService.updateSource(source);
        return "redirect:/source/list.do";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam("id") Integer[] ids) {
        this.sourceService.deleteSource(ids);
        return "redirect:/source/list.do";
    }
}
