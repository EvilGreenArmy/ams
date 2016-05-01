package com.ams.service.admin.impl;

import com.ams.dao.admin.SystemMapper;
import com.ams.service.admin.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Reason on 2016/5/1.
 */
@Service(value = "systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemDao;

    @Override
    public void updateTimeliness(Integer days) {
        systemDao.updateTimeliness(days);
    }

    @Override
    public Integer getTimeliness() {
        return systemDao.getTimeliness();
    }
}
