package com.ams.controller.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reason on 2016/3/27.
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Page<CategoryInfo> page = new Page<CategoryInfo>();
        page.setCurrentPage(1);
        page.setTotalPage(10);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "A");
        page = this.categoryService.queryList();
        model.addAttribute("page", page);
        model.addAttribute("status", "A");
        return "login/list";
    }

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        CategoryInfo parent = new CategoryInfo();
        parent.setId(1);
        CategoryInfo category = new CategoryInfo();
        category.setName("性别");
        category.setStatus("A");
        this.categoryService.saveCategory(category);
        return "category/list";
    }



}
