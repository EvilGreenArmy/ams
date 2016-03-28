package com.ams.dao.admin;

import com.ams.entities.admin.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/16.
 */
@Repository
public interface UserMapper {

    List<UserInfo> userQueryPage(Map map);

    void insertUser(UserInfo user);

    List<UserInfo> getUser(UserInfo userInfo);

    List<UserInfo> getUserById(Integer id);

    void updateUser(UserInfo userInfo);

    void deleteUser(Integer[] ids);
}
