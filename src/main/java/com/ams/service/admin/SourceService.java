package com.ams.service.admin;

import com.ams.entities.admin.SourceInfo;
import com.ams.entities.admin.UserInfo;

import java.util.List;

/**
 * 菜单服务接口.
 * Created by Evan on 2016/3/27.
 */
public interface SourceService {

    public List<SourceInfo> getParentSource(UserInfo user);

    public List<SourceInfo> getChildrenSource(UserInfo user);
}
