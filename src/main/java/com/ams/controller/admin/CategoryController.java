package com.ams.controller.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CategoryService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/27.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private static Logger logger = Logger.getLogger(CategoryController.class);

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model, Page<CategoryInfo> page) {
//        Page<CategoryInfo> page = new Page<CategoryInfo>();
//        page.setCurrentPage(currentPage);
//        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        page = categoryService.queryList(paramMap);
        logger.debug("Page info : " + page);
        model.addAttribute("page", page);
        return "category/list";
    }

    @RequestMapping(value = "subList", method = RequestMethod.GET)
    public String subList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                          @RequestParam("parentId") Integer parentId) {
        logger.debug("ParentId:" + parentId);
        List<CategoryInfo> list = this.categoryService.querySubCategorys(parentId);
        model.addAttribute("parentId", parentId);
        model.addAttribute("list", list);
        return "category/subList";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String initAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer parentId) {
        logger.debug("initAdd parentId:"+parentId);
        model.addAttribute("parentId",parentId);
        CategoryInfo category = new CategoryInfo();
        model.addAttribute("category", category);
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute CategoryInfo category, Integer parentId) {
        if(parentId != null){
            CategoryInfo parent = new CategoryInfo();
            parent.setId(parentId);
            category.setParent(parent);
            this.categoryService.saveCategory(category);
            return "redirect:/category/subList.do?parentId="+parentId;
        }
        this.categoryService.saveCategory(category);
        return "redirect:/category/list.do";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String initEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer id) {
        logger.debug("initEdit id:"+id);
        CategoryInfo category = this.categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @ModelAttribute CategoryInfo category, Integer parentId) {
        logger.debug("edit :"+category);
        if(parentId != null){
            CategoryInfo parent = new CategoryInfo();
            parent.setId(parentId);
            category.setParent(parent);
            this.categoryService.editCategory(category);
            return "redirect:/category/subList.do?parentId="+parentId;
        }
        this.categoryService.editCategory(category);
        return "redirect:/category/list.do";
    }

    @RequestMapping(value = "checkCategoryName", method = RequestMethod.GET)
    public @ResponseBody
    String checkCategoryName(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam("name") String name) {
        boolean exist = this.categoryService.checkCategoryName(name, null);
        StringBuffer sb = new StringBuffer("{");
        if(exist) {
            sb.append("\"state\":\"1\"");
        } else {
            sb.append("\"state\":\"0\"");
        }
        sb.append("}");
        logger.debug(sb.toString());
        return sb.toString();
    }


    @RequestMapping(value = "del", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model, Integer[] id, Integer parentId) {
        logger.debug("delete ids:" + Arrays.asList(id));
        this.categoryService.deletes(id);
        if(parentId != null){
            return "redirect:/category/subList.do?parentId="+parentId;
        }
        return "redirect:/category/list.do";
    }


}
