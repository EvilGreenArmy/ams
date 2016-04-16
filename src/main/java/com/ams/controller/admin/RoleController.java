package com.ams.controller.admin;

import com.ams.entities.admin.*;
import com.ams.pagination.Page;
import com.ams.service.admin.RoleService;
import com.ams.service.admin.SourceService;
import com.ams.util.Constant;
import com.ams.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/30.
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private SourceService sourceService;
    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam(value="name", required = false) String name,
                       @RequestParam(value="description", required = false) String description) {
        Page<RoleInfo> page = new Page<RoleInfo>();
        page.setCurrentPage(currentPage);
        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("name", name);
        paramMap.put("description", description);
        page = this.roleService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);
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
    @RequestMapping(value = "assign", method = RequestMethod.GET)
    public String initAssign(HttpServletRequest request, HttpServletResponse response,
                             ModelMap model,
                             @RequestParam("id") Integer roleId) {
        StringBuffer sb = new StringBuffer("[");
        List<SourceInfo> parent = this.sourceService.getParentSource();
        List<SourceInfo> children = this.sourceService.getChildrenSource();
        UserInfo user = (UserInfo) getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        Map<Integer, Integer> map = this.sourceService.getRoleSource(roleId);
        if(parent != null && parent.size() > 0) {
            for (SourceInfo source : parent) {
                sb.append("{ \"id\":\"").append(source.getId()).append("\",\"name\":\"").append(source.getName()).append("\", \"pId\":\"0\", \"open\":\"true\"");
                if(map.containsKey(source.getId())) {
                    sb.append(",\"checked\":\"true\"");
                }
                sb.append("},");
            }
        }
        if(children != null && children.size() > 0) {
            for (SourceInfo source : children) {
                sb.append("{ \"id\":\"").append(source.getId()).append("\",\"name\":\"")
                        .append(source.getName()).append("\", \"pId\":\"").
                        append(source.getParentInfo().getId()).append("\", \"open\":\"true\"");
                if(map.containsKey(source.getId())) {
                    sb.append(",\"checked\":\"true\"");
                }
                sb.append("},");
            }
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        model.addAttribute("roleId", roleId);
        model.addAttribute("data", sb.toString());
        return "role/assign";
    }
    @RequestMapping(value = "assign", method = RequestMethod.POST)
    public String assign(HttpServletRequest request, HttpServletResponse response,
                         ModelMap model,
                         @RequestParam("role") Integer roleId,
                         @RequestParam("sources") String sources) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("roleId", roleId);
        if(StringUtil.isNotBlank(sources)) {
            String[] sourceArr = sources.split(",");
            if(sourceArr != null && sourceArr.length > 0) {
                List<SourceDutyInfo> sourceDutyList = new ArrayList<SourceDutyInfo>();
                for(String str : sourceArr) {
                    SourceDutyInfo sourceDuty = new SourceDutyInfo();
                    sourceDuty.setRoleId(roleId);
                    sourceDuty.setSourceId(Integer.parseInt(str));
                    sourceDutyList.add(sourceDuty);
                }
                map.put("sourceDuty", sourceDutyList);
            }
        }
        this.roleService.saveSourceDuty(map);
        return "user/assign";
    }
}
