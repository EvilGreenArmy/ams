package com.ams.service.admin;

import com.ams.entities.admin.SourceInfo;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 菜单服务接口.
 * Created by Evan on 2016/3/27.
 */
public interface SourceService {

    public List<SourceInfo> getParentSource(UserInfo user);

    public List<SourceInfo> getChildrenSource(UserInfo user);

    Page<SourceInfo> queryList(Map<String, Object> paramMap);

    public void saveSource(SourceInfo source);

    public SourceInfo getSourceById(Integer id);

    public void updateSource(SourceInfo source);

    public void deleteSource(Integer[] ids);

    public List<SourceInfo> getParentSource();

    public List<SourceInfo> getChildrenSource();

    public Map<Integer, Integer> getRoleSource(Integer roleId);
}
