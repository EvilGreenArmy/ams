package com.ams.controller;

import com.ams.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Evan on 2016/3/15.
 */
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            LOGGER.error("会话不存在！");
            session = request.getSession(true);
        }
        return session;
    }
}
