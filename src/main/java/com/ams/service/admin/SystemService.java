package com.ams.service.admin;

import com.ams.entities.admin.CategoryInfo;
import com.ams.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/27.
 */
public interface SystemService {
    public void updateTimeliness(Integer category);
    public Integer getTimeliness();
}
