package com.ams.service.admin.impl;

import com.ams.dao.admin.CategoryMapper;
import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Reason on 2016/3/27.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryDao;

    @Override
    public Page<CategoryInfo> queryList() {
        return null;
    }

    @Override
    public void saveCategory(CategoryInfo category) {
        categoryDao.insertCategory(category);
    }
}
