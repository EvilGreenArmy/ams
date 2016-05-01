package com.ams.controller.admin;

import com.ams.entities.admin.ProductInfo;
import com.ams.entities.admin.ServiceResponse;
import com.ams.service.admin.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Reason on 2016/5/1.
 */
@Controller
@RequestMapping(value = "/webservice")
public class ServiceController extends BaseController {

    private static Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "add")
    @ResponseBody
    public ServiceResponse add(HttpServletRequest request, HttpServletResponse response, ModelMap model, ProductInfo productInfo) {
        logger.debug(productInfo);

        productInfo.setStatus("2");


        ServiceResponse res = new ServiceResponse();

        //productService.saveProduct(productInfo);
        return res;
    }



}
