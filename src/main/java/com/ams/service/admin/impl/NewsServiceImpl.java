package com.ams.service.admin.impl;

import com.ams.dao.admin.NewsMapper;
import com.ams.entities.admin.NewsInfo;
import com.ams.service.NewsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/5/2.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper dao;
    @Override
    public Map<String, List<NewsInfo>> getNewsInfo() {
        Map<String, List<NewsInfo>> dataMap = new HashMap<String, List<NewsInfo>>();
        List<NewsInfo> newsList = this.dao.getNewsInfo();
        if(CollectionUtils.isNotEmpty(newsList)) {
            List<NewsInfo> news;
            for(NewsInfo newsInfo : newsList) {
                if(dataMap.containsKey(newsInfo.getType())) {
                    news = dataMap.get(newsInfo.getType());
                } else {
                    news = new ArrayList<NewsInfo>(10);
                }
                news.add(newsInfo);
                dataMap.put(newsInfo.getType(), news);
            }

        }
        return dataMap;
    }

    @Override
    public NewsInfo getNewsById(Integer id) {
        List<NewsInfo> newsList = this.dao.getNewsById(id);
        if(CollectionUtils.isNotEmpty(newsList)) {
            return newsList.get(0);
        }
        return null;
    }


}
