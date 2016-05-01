package com.ams.service.admin;

import com.ams.entities.admin.ProductInfo;
import com.ams.pagination.Page;

import java.util.List;
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

    public void approve(Integer id, String status);

    public List<ProductInfo> frontQuery(String status);
}
