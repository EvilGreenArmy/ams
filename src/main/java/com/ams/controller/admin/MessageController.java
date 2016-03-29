package com.ams.controller.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息控制类
 * Created by Reason on 2016/3/28.
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    private static Logger logger = Logger.getLogger(CategoryController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<MessageInfo> page) {

        logger.debug("Page info : " + page);
        model.addAttribute("page", page);
        return "message/list";

    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer toUserId){
        if(null != toUserId){
            UserInfo toUser = userService.getUserById(toUserId);
            model.addAttribute("toUser",toUser);
        }
        return "message/add";
    }

}
