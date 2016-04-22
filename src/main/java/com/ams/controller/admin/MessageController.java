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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 后台管理员查询
     */
    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<MessageInfo> page,
                       @RequestParam(value="title", required = false) String title, @RequestParam(value="content", required = false)String content) {

        logger.debug("Page info : " + title);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("title", title);
        paramMap.put("content", content);
        page = messageService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);

        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        logger.debug("Messages:"+messageService.queryUnreadMessage(currentUser.getId()));

        return "message/list";

    }

    /**
     * 前台用户查询
     */
    @RequestMapping(value = "frontList")
    public String frontList(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<MessageInfo> page,
                       @RequestParam(value="title", required = false) String title, @RequestParam(value="content", required = false)String content) {
        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        logger.debug("Page info : " + title);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("title", title);
        paramMap.put("content", content);
        paramMap.put("toUserId", currentUser.getId());
        page = messageService.queryFrontList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);
        return "message/frontList";

    }


    /**
     * 进入发送信息页面
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer toUserId, @RequestParam(value="um", required = false)Integer um){
        if(null != um){
            this.messageService.setRead(um);
        }
        if(null != toUserId){
            UserInfo toUser = userService.getUserById(toUserId);
            model.addAttribute("toUser",toUser);
            return "message/frontAdd";
        }else {
            return "message/add";
        }
    }


    /**
     * 保存发送消息
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute MessageInfo message, Integer toUserId) {

        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        message.setFromUser(currentUser);
        message.setSendDate(new Date());
        message.setStatus("A");
        this.messageService.saveMessage(message, toUserId);
        if(null != toUserId){
            return "redirect:/message/frontList.do";
        }
        return "redirect:/message/list.do";
    }

    /**
     * 显示消息信息
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer um,Integer m){
        MessageInfo message = this.messageService.getMessageById(m);
        this.messageService.setRead(um);
        model.addAttribute("message",message);
        return "message/frontDetail";
    }


}
