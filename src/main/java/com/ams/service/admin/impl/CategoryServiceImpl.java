package com.ams.service.admin.impl;

import com.ams.dao.admin.CategoryMapper;
import com.ams.entities.admin.CategoryInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/27.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryDao;

    @Override
    public List<CategoryInfo> querySubCategorys(Integer parentId) {
        return categoryDao.querySubCategorys(parentId);
    }

    @Override
    public boolean checkCategoryName(String categoryName, Integer parentId) {

        CategoryInfo category = new CategoryInfo();
        category.setName(categoryName);
        if(parentId != null){
            CategoryInfo parent = new CategoryInfo();
            parent.setId(parentId);
            category.setParent(parent);
        }
        CategoryInfo result = categoryDao.getCategory(category);
        if(result == null){
            return false;
        }
        return true;
    }

    @Override
    public Page<CategoryInfo> queryList() {
        Page<CategoryInfo> page = new Page<CategoryInfo>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        List<CategoryInfo> result = categoryDao.categoryQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Override
    public void saveCategory(CategoryInfo category) {
        categoryDao.insertCategory(category);
    }

    @Override
    public CategoryInfo getCategoryById(Integer id) {
        return this.categoryDao.getCategoryById(id);
    }

    @Override
    public void editCategory(CategoryInfo category) {
        this.categoryDao.updateCategory(category);
    }

    @Override
    public void deletes(Integer[] ids) {
        this.categoryDao.deletes(ids);
}
}
