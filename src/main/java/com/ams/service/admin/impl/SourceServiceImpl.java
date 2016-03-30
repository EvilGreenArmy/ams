package com.ams.service.admin.impl;

import com.ams.dao.admin.SourceMapper;
import com.ams.entities.admin.SourceInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public Page<SourceInfo> queryList(Map<String, Object> paramMap) {
        Page<SourceInfo> page = (Page<SourceInfo>) paramMap.get("page");
        List<SourceInfo> result = sourceDao.sourceQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveSource(SourceInfo source) {
        sourceDao.insertSource(source);
    }

    @Override
    public SourceInfo getSourceById(Integer id) {
        List<SourceInfo> sourceList = sourceDao.getSourceById(id);
        if (sourceList != null && sourceList.size() > 0) {
            return sourceList.get(0);
        }
        return new SourceInfo();
    }

    @Transactional
    public void updateSource(SourceInfo source) {
        sourceDao.updateSource(source);
    }

    @Transactional
    public void deleteSource(Integer[] ids) {
        sourceDao.deleteSource(ids);
    }
}
