package com.ams.controller.admin;

import com.ams.service.admin.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Evan on 2016/3/15.
 */
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    CategoryService categoryService;

    public HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            LOGGER.error("会话不存在！");
            session = request.getSession(true);
        }
        return session;
    }
}
