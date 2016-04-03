package com.ams.service.admin.impl;

import com.ams.entities.admin.ProductInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.ProductService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Reason on 2016/3/26.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Override
    public Page<ProductInfo> queryList(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public void saveProduct(ProductInfo product) {

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
