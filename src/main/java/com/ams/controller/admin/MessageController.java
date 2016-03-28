package com.ams.controller.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.pagination.Page;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息控制类
 * Created by Reason on 2016/3/28.
 */
public class MessageController extends BaseController {

    private static Logger logger = Logger.getLogger(CategoryController.class);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<MessageInfo> page) {

        logger.debug("Page info : " + page);
        model.addAttribute("page", page);
        return "category/list";
    }
}
