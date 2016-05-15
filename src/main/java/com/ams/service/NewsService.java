package com.ams.service;

import com.ams.entities.admin.NewsInfo;
import com.ams.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/5/2.
 */
public interface NewsService {

    public Map<String, List<NewsInfo>> getNewsInfo();

    public NewsInfo getNewsById(Integer id);

    public Map<String, Integer> getNewsAmount();

    Page<NewsInfo> queryList(Map<String, Object> paramMap);

}
