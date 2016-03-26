package com.ams.controller.admin;

import com.ams.entities.admin.SourceInfo;
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
import java.util.ArrayList;
import java.util.List;

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
        SourceInfo userSource = new SourceInfo();
        userSource.setName("基础信息");
        userSource.setId(1);
        SourceInfo userSource1 = new SourceInfo();
        userSource1.setName("系统信息");
        userSource1.setId(2);
        List<SourceInfo> parentList = new ArrayList<SourceInfo>();
        parentList.add(userSource);
        parentList.add(userSource1);
        SourceInfo t1 = new SourceInfo();
        t1.setName("用户管理");
        t1.setId(10);
        t1.setParentInfo(userSource);

        SourceInfo t2 = new SourceInfo();
        t2.setName("菜单管理");
        t2.setId(11);
        t2.setParentInfo(userSource);

        SourceInfo t3 = new SourceInfo();
        t3.setName("权限管理");
        t3.setId(12);
        t3.setParentInfo(userSource);

        List<SourceInfo> menuList = new ArrayList<SourceInfo>();
        menuList.add(t1);
        menuList.add(t2);
        menuList.add(t3);
        SourceInfo t4 = new SourceInfo();
        t4.setName("aaaaaa ");
        t4.setId(10);
        t4.setParentInfo(userSource1);

        SourceInfo t5 = new SourceInfo();
        t5.setName("bbbbbbbb");
        t5.setId(11);
        t5.setParentInfo(userSource1);

        SourceInfo t6 = new SourceInfo();
        t6.setName("ccccccc");
        t6.setId(12);
        t6.setParentInfo(userSource1);
        menuList.add(t4);
        menuList.add(t5);
        menuList.add(t6);
        model.addAttribute("parentList", parentList);
        model.addAttribute("menuList", menuList);
        return "base.definition";
    }

}
