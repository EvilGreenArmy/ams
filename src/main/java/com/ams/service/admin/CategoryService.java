package com.ams.service.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;

/**
 * Created by Reason on 2016/3/27.
 */
public interface CategoryService {
    Page<CategoryInfo> queryList();

    public void saveCategory(CategoryInfo category);
}
