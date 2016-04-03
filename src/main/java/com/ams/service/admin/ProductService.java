package com.ams.service.admin;

import com.ams.entities.admin.ProductInfo;
import com.ams.pagination.Page;

import java.util.Map;

/**
 * Created by Reason on 2016/3/26.
 */
public interface ProductService {

    public Page<ProductInfo> queryList(Map<String, Object> paramMap);

    public void saveProduct(ProductInfo product);

    public void editProduct(ProductInfo product);

    public ProductInfo getProductById(Integer id);

    public void updateProduct(ProductInfo product);

    public void deleteProduct(Integer id);
}
