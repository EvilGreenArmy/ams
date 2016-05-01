package com.ams.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Evan on 2016/4/4.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    @Value("${tms.url}")
    String tmsUrl;

    @RequestMapping(value = "portal")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        model.addAttribute("tmsUrl", tmsUrl);
        return "main/index";
    }

    public void setTmsUrl(String tmsUrl) {
        this.tmsUrl = tmsUrl;
    }
}
