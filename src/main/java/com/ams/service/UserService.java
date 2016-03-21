package com.ams.service;

import com.ams.entities.UserInfo;
import com.ams.pagination.Page;

/**
 * Created by Evan on 2016/3/15.
 */
public interface UserService {

    Page<UserInfo> queryList();

    public void saveUser(UserInfo user);

    public UserInfo getUserByLogin(String userName, String password);
}
