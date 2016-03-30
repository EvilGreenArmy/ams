package com.ams.controller.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.MessageService;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<MessageInfo> page) {

        logger.debug("Page info : " + page);
        page = messageService.queryList();
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


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute MessageInfo message, Integer toUserId) {

        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        message.setFromUser(currentUser);
        message.setSendDate(new Date());
        message.setStatus("未读");
        this.messageService.saveMessage(message, null);
        return "redirect:/message/list.do";
    }

}
