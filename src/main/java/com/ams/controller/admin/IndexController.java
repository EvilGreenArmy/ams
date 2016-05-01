package com.ams.controller.admin;

import com.ams.entities.admin.ProductInfo;
import com.ams.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/4/4.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    @Value("${tms.url}")
    String tmsUrl;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "portal")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        model.addAttribute("tmsUrl", tmsUrl);

        List<ProductInfo> list1 = productService.frontQuery("1");

        model.addAttribute("list1", list1);



        return "main/index";
    }

    public void setTmsUrl(String tmsUrl) {
        this.tmsUrl = tmsUrl;
    }
}
