package com.ams.service.admin.impl;

import com.ams.dao.admin.ProductMapper;
import com.ams.entities.admin.ProductInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.ProductService;
import com.ams.service.admin.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Reason on 2016/3/26.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productDao;
    @Autowired
    public SystemService systemService;

    @Override
    public Page<ProductInfo> queryList(Map<String, Object> paramMap) {
        Page<ProductInfo> page = (Page<ProductInfo>)paramMap.get("page");
        List<ProductInfo> result = productDao.productQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Override
    public void saveProduct(ProductInfo product) {
        Integer days = systemService.getTimeliness();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,days);
        product.setPastDate(calendar.getTime());
        productDao.insertProduct(product);
    }

    @Override
    public void editProduct(ProductInfo product) {
        productDao.updateProduct(product);
    }

    @Override
    public ProductInfo getProductById(Integer id) {
        return productDao.getProductById(id);
    }

    @Override
    public void updateProduct(ProductInfo product) {

    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public void approve(Integer id, String status) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id",id);
        paramMap.put("status",status);
        productDao.updateStatus(paramMap);
    }

    @Override
    public List<ProductInfo> frontQuery(String status) {
        return productDao.frontQuery(status);
    }
}
