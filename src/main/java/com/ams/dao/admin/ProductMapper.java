package com.ams.dao.admin;

import com.ams.entities.admin.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Reason on 2016/3/26.
 */
@Repository
public interface ProductMapper {

    List<ProductInfo> productQueryPage(Map map);

    void insertUser(ProductInfo product);
}
