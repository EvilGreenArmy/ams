package com.ams.controller.admin;

import com.ams.entities.admin.AccountDutyInfo;
import com.ams.entities.admin.RoleInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.RoleService;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
import com.ams.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Evan on 2016/3/15.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value="currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value="pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam(value="acctName", required = false) String acctName,
                       @RequestParam(value="userName", required = false) String userName) {
        Page<UserInfo> page = new Page<UserInfo>();
        page.setCurrentPage(currentPage);
        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("acctName", acctName);
        paramMap.put("userName", userName);
        page = this.userService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);
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
    @RequestMapping(value = "checkAcctName", method = RequestMethod.POST)
    public @ResponseBody String checkAcctName(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @RequestParam("acctName") String acctName, @RequestParam(value = "id", required = false) Integer id) {
        UserInfo user = new UserInfo();
        user.setAcctName(acctName);
        if(id  != null) {
            user.setId(id);
        }
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
    @RequestMapping(value = "assign", method = RequestMethod.GET)
    public String initAssign(HttpServletRequest request, HttpServletResponse response,
                             ModelMap model,
                             @RequestParam("id") Integer acctId) {
        List<RoleInfo> roleList = this.roleService.getAllRole();
        Map<Integer, Integer> map = this.roleService.getAccountRole(acctId);
        StringBuffer sb = new StringBuffer("[");
        if(roleList != null && roleList.size() > 0) {
            for(RoleInfo role : roleList) {
                sb.append("{ \"id\":\"").append(role.getId()).append("\",\"name\":\"").append(role.getName()).append("\", \"open\":\"true\"");
                if(map.containsKey(role.getId())) {
                    sb.append(",\"checked\":\"true\"");
                }
                sb.append("},");
            }
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        model.addAttribute("acctId", acctId);
        model.addAttribute("data", sb.toString());
        return "user/assign";
    }
    @RequestMapping(value = "assign", method = RequestMethod.POST)
    public String assign(HttpServletRequest request, HttpServletResponse response,
                             ModelMap model,
                             @RequestParam("acctId") Integer acctId,
                             @RequestParam("roles") String roles) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("acctId", acctId);
        if(StringUtil.isNotBlank(roles)) {
            String[] rolesArr = roles.split(",");
            if(rolesArr != null && rolesArr.length > 0) {
                List<AccountDutyInfo> roleList = new ArrayList<AccountDutyInfo>();
                for(String str : rolesArr) {
                    AccountDutyInfo acctDuty = new AccountDutyInfo();
                    acctDuty.setDutyId(Integer.parseInt(str));
                    acctDuty.setAccountId(acctId);
                    roleList.add(acctDuty);
                }
                map.put("acctRoles", roleList);
            }
        }
        this.userService.editAccountDuty(map);
        return "user/assign";
    }
}
