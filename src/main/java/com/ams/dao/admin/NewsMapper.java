package com.ams.dao.admin;


import com.ams.entities.admin.NewsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/5/2.
 */
@Repository
public interface NewsMapper {
    List<NewsInfo> getNewsInfo();

    List<NewsInfo> getNewsById(Integer id);

    List<Integer> getNewsAmount();

    List<NewsInfo> newsQueryPage(Map map);
}
