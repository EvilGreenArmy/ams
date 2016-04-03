package com.ams.service.admin.impl;

import com.ams.dao.admin.ProductMapper;
import com.ams.entities.admin.ProductInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/26.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productDao;

    @Override
    public Page<ProductInfo> queryList(Map<String, Object> paramMap) {
        Page<ProductInfo> page = (Page<ProductInfo>)paramMap.get("page");
        List<ProductInfo> result = productDao.productQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Override
    public void saveProduct(ProductInfo product) {
        productDao.insertProduct(product);
    }

    @Override
    public void editProduct(ProductInfo product) {

    }

    @Override
    public ProductInfo getProductById(Integer id) {
        return null;
    }

    @Override
    public void updateProduct(ProductInfo product) {

    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
