package com.ams.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ams.entities.admin.*;
import com.ams.service.admin.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Reason on 2016/5/1.
 */
@Controller
@RequestMapping(value = "/webservice")
public class ServiceController extends BaseController {

    private static Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "rest/save")
    public @ResponseBody ServiceResponse add(HttpServletRequest request, HttpServletResponse response, ModelMap model,@RequestBody ProductInfoTemp productInfo) {
        logger.debug(productInfo);
        ServiceResponse res = new ServiceResponse();
        try {
            productInfo.setStatus("2");
            //productService.saveProduct(productInfo);

        }catch (Exception e) {
            logger.error("保存失败。", e);
            res.setCode(500);
            res.setMessage(e.getMessage());
        }

        return res;
    }


    @RequestMapping(value = "rest/list")
    public  @ResponseBody ServiceResponse list(HttpServletRequest request, HttpServletResponse response, ModelMap model, ServiceRequest serviceRequest) {

        logger.info(serviceRequest);
        ServiceResponse res = new ServiceResponse();
        try {
            List<ProductInfo> list = productService.serviceQueryList(serviceRequest);
            logger.info(list.get(0));
            res.setData(list);
        }catch (Exception e){
            logger.error("获取成果、专利失败。",e);
            res.setCode(500);
            res.setMessage(e.getMessage());
        }

        return res;
    }


}
