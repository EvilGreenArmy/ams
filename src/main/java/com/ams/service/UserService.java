package com.ams.service;

import com.ams.entities.UserInfo;
import com.ams.pagination.Page;

/**
 * Created by Evan on 2016/3/15.
 */
public interface UserService {

    Page<UserInfo> queryList(Page<UserInfo> page);

    public void saveUser(UserInfo user);
}
