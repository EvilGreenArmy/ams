package com.ams.dao;

import com.ams.entities.UserInfo;
import com.ams.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Evan on 2016/3/16.
 */
public interface UserMapper {

    List<UserInfo> userQueryPage(@Param("page") Page page);

    void insertUser(UserInfo user);
}
