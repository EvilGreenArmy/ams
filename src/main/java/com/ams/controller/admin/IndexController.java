package com.ams.controller.admin;

import com.ams.entities.admin.NewsInfo;
import com.ams.entities.admin.ProductInfo;
import com.ams.service.NewsService;
import com.ams.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Value("${cms.url}")
    String cmsUrl;
    @Autowired
    private ProductService productService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "portal")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        model.addAttribute("tmsUrl", tmsUrl);
        model.addAttribute("cmsUrl", cmsUrl);
        model.addAttribute("list1", productService.frontQuery("1"));
        model.addAttribute("list2", productService.frontQuery("2"));
        model.addAttribute("list5", productService.frontQuery("5"));
        model.addAttribute("list6", productService.frontQuery("6"));

        model.addAttribute("list3", productService.frontQuery("3"));
        model.addAttribute("list4", productService.frontQuery("4"));
        model.addAttribute("newsMap", this.newsService.getNewsInfo());



        return "main/index";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String productDetail(HttpServletRequest request, HttpServletResponse response,
                          Model model, @RequestParam(value="id") Integer id) {

        model.addAttribute("pro", productService.getProductById(id));

        return "frontpage/frontDetail";
    }

    @RequestMapping(value = "productDetail", method = RequestMethod.GET)
    public String product(HttpServletRequest request, HttpServletResponse response,
                          Model model, @RequestParam(value="t", required = false, defaultValue = "") String type) {
        return "frontpage/frontDetail"+type;
    }
    @RequestMapping(value = "news", method = RequestMethod.GET)
    public String news(HttpServletRequest request, HttpServletResponse response,
                          Model model, @RequestParam(value="id", required = true) Integer id) {
        NewsInfo newsInfo = this.newsService.getNewsById(id);
        model.addAttribute("newsInfo", newsInfo);
        return "frontpage/news";
    }

    public void setTmsUrl(String tmsUrl) {
        this.tmsUrl = tmsUrl;
    }

    public String getCmsUrl() {
        return cmsUrl;
    }

    public void setCmsUrl(String cmsUrl) {
        this.cmsUrl = cmsUrl;
    }
}
