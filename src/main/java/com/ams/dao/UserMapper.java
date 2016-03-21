package com.ams.dao;

import com.ams.entities.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/16.
 */
public interface UserMapper {

    List<UserInfo> userQueryPage(Map map);

    void insertUser(UserInfo user);
}
