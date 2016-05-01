package com.ams.controller.admin;

import com.ams.service.admin.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Evan on 2016/4/4.
 */
@Controller
@RequestMapping("/timeliness")
public class TimelinessController extends BaseController {

    @Autowired
    public SystemService systemService;


    @RequestMapping(value = "edit")
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        Integer timeliness = systemService.getTimeliness();
        model.addAttribute("timeliness",timeliness);
        return "timeliness/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer timeliness) {
        systemService.updateTimeliness(timeliness);
        model.addAttribute("timeliness",timeliness);
        return "timeliness/edit";
    }
}
