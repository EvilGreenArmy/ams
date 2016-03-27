package com.ams.service.admin.impl;

import com.ams.dao.admin.SourceMapper;
import com.ams.entities.admin.SourceInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.service.admin.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evan on 2016/3/27.
 */
@Service("sourceService")
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceMapper sourceDao;
    @Override
    public List<SourceInfo> getParentSource(UserInfo user) {
        return sourceDao.getParentSource(user);
    }

    @Override
    public List<SourceInfo> getChildrenSource(UserInfo user) {
        return sourceDao.getChildrenSource(user);
    }
}
