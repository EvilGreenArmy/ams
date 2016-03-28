package com.ams.service.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;

import java.util.List;

/**
 * Created by Reason on 2016/3/27.
 */
public interface CategoryService {
    Page<CategoryInfo> queryList();
    public void saveCategory(CategoryInfo category);
    public boolean checkCategoryName(String categoryName, Integer parentId);
    public List<CategoryInfo> querySubCategorys(Integer parentId);
    public CategoryInfo getCategoryById(Integer id);
    public void editCategory(CategoryInfo category);
    public void deletes(Integer[] ids);
}
