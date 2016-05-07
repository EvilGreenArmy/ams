package com.ams.dao.admin;


import com.ams.entities.admin.NewsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Evan on 2016/5/2.
 */
@Repository
public interface NewsMapper {
    List<NewsInfo> getNewsInfo();

    List<NewsInfo> getNewsById(Integer id);
}
