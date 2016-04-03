package com.ams.controller.admin;

import com.ams.entities.admin.ProductInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.ProductService;
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
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 产品控制类
 * Created by Reason on 2016/3/26.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    private static Logger logger = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<ProductInfo> page) {

        logger.debug("Page info : " + page);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        page = productService.queryList(paramMap);
        model.addAttribute("page", page);
        return "product/list";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model, String type) {
        logger.debug("initEdit type:" + type);
        if("1".equals(type))
            model.addAttribute("typeName", "成果");
        else
            model.addAttribute("typeName", "专利");
        model.addAttribute("type", type);
        return "product/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute ProductInfo product) {
        logger.debug("product info :"+product.toString());

        product.setStartDate(new Date());
        product.setEndDate(new Date());

        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        product.setAddDate(new Date());
        product.setAddUser(currentUser);
        product.setEditDate(new Date());
        product.setEditUser(currentUser);
        product.setStatus(Constant.ACTIVE_STATUS);
        this.productService.saveProduct(product);
        return "redirect:/product/list.do";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer id) {
        logger.debug("initEdit id:"+id);
        ProductInfo product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute ProductInfo product) {
        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        product.setEditDate(new Date());
        product.setEditUser(currentUser);
        this.productService.editProduct(product);
        return "redirect:/product/list.do";
    }
}
