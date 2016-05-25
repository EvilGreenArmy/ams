package com.ams.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ams.entities.admin.ProductInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.ProductService;
import com.ams.service.admin.SystemService;
import com.ams.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

    @Value("${wlgj.url}")
    String httpToWLURL;

    @Autowired
    private ProductService productService;

    private static Logger logger = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<ProductInfo> page,
            @RequestParam(value="type", required = false) String type,@RequestParam(value="name", required = false) String name) {

        logger.debug("Page info : " + page);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(null != type){
            paramMap.put("type", type);
        }
        if(null != name){
            paramMap.put("name", name);
        }
        paramMap.put("page", page);
        page = productService.queryList(paramMap);
        model.addAttribute("paramMap", paramMap);
        model.addAttribute("page", page);
        return "product/list";

    }

    @RequestMapping(value = "frontList")
    public String frontList(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<ProductInfo> page,
        @RequestParam(value="flag", required = false) String flag,@RequestParam(value="type", required = false) String type,
        @RequestParam(value="name", required = false) String name) {
        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        logger.debug("Page info : " + page);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if("my".equals(flag)){
            paramMap.put("addUserId", currentUser.getId());
        }
        if(null != type){
            paramMap.put("type", type);
        }
        if(null != name){
            paramMap.put("name", name);
        }
        paramMap.put("page", page);
        page = productService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("paramMap", paramMap);
        if("my".equals(flag)){
            return "product/frontList";
        }else{
            return "product/frontQueryList";
        }

    }

    @Deprecated
    @RequestMapping(value = "approveList")
    public String approveList(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<ProductInfo> page,
                       @RequestParam(value="type", required = false) String type,@RequestParam(value="name", required = false) String name) {

        logger.debug("Page info : " + page);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(null != type){
            paramMap.put("type", type);
        }
        if(null != name){
            paramMap.put("name", name);
        }
        paramMap.put("status", Constant.NO_STATUS);
        paramMap.put("page", page);
        page = productService.queryList(paramMap);
        model.addAttribute("paramMap", paramMap);
        model.addAttribute("page", page);
        return "product/approveList";

    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model, String type) {

        // 单位属性
        model.addAttribute("organsAttributes",categoryService.querySubCategorys(17));
        // 任务来源
        model.addAttribute("taskSources",categoryService.querySubCategorys(125));
        // 密级
        model.addAttribute("secretLevels", categoryService.querySubCategorys(132));
        // 竞价单位
        model.addAttribute("priceUnits",categoryService.querySubCategorys(156));

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
        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        product.setAddDate(new Date());
        product.setAddUser(currentUser);
        product.setEditDate(new Date());
        product.setEditUser(currentUser);
        product.setStatus(Constant.PRODUCT_STATUS_1);
        doPost(product,httpToWLURL);
        this.productService.saveProduct(product);
        return "redirect:/product/frontList.do?flag=my";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer id) {
        logger.debug("initEdit id:"+id);
        // 单位属性
        model.addAttribute("organsAttributes", categoryService.querySubCategorys(17));
        // 任务来源
        model.addAttribute("taskSources", categoryService.querySubCategorys(125));
        // 密级
        model.addAttribute("secretLevels", categoryService.querySubCategorys(132));
        // 竞价单位
        model.addAttribute("priceUnits",categoryService.querySubCategorys(156));

        ProductInfo product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @RequestMapping(value = "frontEdit", method = RequestMethod.GET)
    public String frontEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer id) {
        logger.debug("initEdit id:"+id);
        // 单位属性
        model.addAttribute("organsAttributes",categoryService.querySubCategorys(17));
        // 任务来源
        model.addAttribute("taskSources",categoryService.querySubCategorys(125));
        // 密级
        model.addAttribute("secretLevels",categoryService.querySubCategorys(132));
        // 竞价单位
        model.addAttribute("priceUnits",categoryService.querySubCategorys(156));

        ProductInfo product = this.productService.getProductById(id);
        doPost(product,httpToWLURL+"/"+product.getId());
        logger.debug("edit product: " + product);
        model.addAttribute("product", product);
        return "product/frontEdit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute ProductInfo product, @RequestParam(value="flag", required = false)String flag) {
        UserInfo currentUser = (UserInfo)getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        product.setEditDate(new Date());
        product.setEditUser(currentUser);
        this.productService.editProduct(product);
        if("front".equals(flag)){
            return "redirect:/product/frontList.do?flag=my";
        }
        return "redirect:/product/list.do";
    }


    @Deprecated
    @RequestMapping(value = "approve", method = RequestMethod.GET)
    public String approve(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam("id")Integer id, @RequestParam("status")Integer status) {

        // 单位属性
        model.addAttribute("organsAttributes", categoryService.querySubCategorys(17));
        // 任务来源
        model.addAttribute("taskSources", categoryService.querySubCategorys(125));
        // 密级
        model.addAttribute("secretLevels",categoryService.querySubCategorys(132));
        // 竞价单位
        model.addAttribute("priceUnits",categoryService.querySubCategorys(156));

        if(status==1){
            productService.approve(id, Constant.ACTIVE_STATUS);
        }else{
            productService.approve(id, Constant.NO_STATUS);
        }
        return "redirect:/product/approveList.do";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer id,
            @RequestParam(value="flag", required = false)String flag,@RequestParam(value="favorite", required = false)String favorite) {
        ProductInfo product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("favorite", favorite);
        if("a".equals(flag)){
            return "product/approveDetail";
        }else if("f".equals(flag)){
            return "product/frontDetail";
        }
        return "product/detail";
    }


    @RequestMapping(value = "del", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer[] id, @RequestParam(value="flag", required = false)String flag) {
        logger.debug("delete ids:" + Arrays.asList(id)+"->"+flag);
        this.productService.deletes(id);
        if("f".equals(flag)){
            return "redirect:/product/frontList.do?flag=my";
        }
        return "redirect:/product/list.do";
    }

    public void doPost(ProductInfo product){
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Map<String, String> param = new HashMap<String, String>();
            param.put("distinguish","zzzh");
            param.put("name", product.getName());
            param.put("chineseName", product.getChineseName());
            param.put("province", product.getProvince());
            param.put("organsAttribute", product.getOrgansAttribute());
            param.put("organization", product.getOrganization());
            param.put("startDate", fmt.format(product.getStartDate()));
            param.put("endDate", fmt.format(product.getEndDate()));
            param.put("type", product.getType());
            param.put("area",product.getArea());
            param.put("addr", product.getAddr());
            param.put("linkman", product.getLinkman());
            param.put("content", product.getContent());
            param.put("telephone",product.getTelephone());
            param.put("zipCode",product.getZipCode());
            param.put("taskSource",product.getTaskSource());
            param.put("isSecret","A".equals(product.getIsSecret())?"有":"无" );
            param.put("secretLevel", product.getSecretLevel());
            param.put("technologyDirectory", product.getTechnologyDirectory());
            post(httpToWLURL,param);
        }catch (Exception e){
            logger.error("Post to weilai fail.",e);
        }

    }


    /**
     * 发送HttpPost请求
     *
     * @param strURL
     *            服务地址
     * @param body
     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
     * @return 成功:返回json字符串<br/>
     */
    public static String post(String strURL, Object body) {
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(JSONObject.toJSON(body).toString());	//fastjson
            out.flush();
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            connection.disconnect();
            return sb.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error"; // 自定义错误信息
    }

}
