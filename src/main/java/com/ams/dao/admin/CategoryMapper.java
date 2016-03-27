package com.ams.dao.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.entities.admin.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/27.
 */
public interface CategoryMapper {

    List<CategoryInfo> categoryQueryPage(Map map);

    void insertCategory(CategoryInfo category);

    CategoryInfo getCategoryById(Integer id);
}
