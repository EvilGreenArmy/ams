package com.ams.controller.admin;

import com.ams.entities.admin.FavoritesInfo;
import com.ams.entities.admin.ProductInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.FavoritesService;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
@Controller
@RequestMapping("/favorites")
public class FavoritesController extends BaseController {
    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<FavoritesInfo> page = new Page<FavoritesInfo>();
        page.setCurrentPage(currentPage);
        page.setShowCount(pageSize);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        UserInfo userInfo = (UserInfo) getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        int isAdmin = 1;
        if (!userService.isAdmin(userInfo.getId())) {
            paramMap.put("acctId", userInfo.getId());
            isAdmin = 0;
        }
        page = this.favoritesService.queryList(paramMap);
        model.addAttribute("page", page);
        model.addAttribute("isAdmin", isAdmin);
        return "favorites/list";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      @RequestParam(value = "productId") Integer productId) {
        FavoritesInfo favoritesInfo = new FavoritesInfo();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(productId);
        favoritesInfo.setProductInfo(productInfo);
        UserInfo userInfo = (UserInfo) getSession(request).getAttribute(Constant.SESSION_LOGIN_USER);
        favoritesInfo.setUserInfo(userInfo);
        favoritesInfo.setCreateTime(new Date());
        this.favoritesService.saveFavorites(favoritesInfo);
        return "redirect:/favorites/list.do";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                         @RequestParam("id") Integer[] ids) {
        this.favoritesService.deleteFavorites(ids);
        return "redirect:/favorites/list.do";
    }
}
