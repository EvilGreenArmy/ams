package com.ams.service.admin;

import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;

import java.util.Map;

/**
 * Created by Evan on 2016/3/15.
 */
public interface UserService {

    Page<UserInfo> queryList(Map<String, Object> paramMap);

    public void saveUser(UserInfo user);

    public UserInfo getUserByLogin(String userName, String password);

    public boolean checkAcctName(UserInfo userInfo);

    public UserInfo getUserById(Integer id);

    public void updateUser(UserInfo user);

    public void deleteUser(Integer[] ids);
}
