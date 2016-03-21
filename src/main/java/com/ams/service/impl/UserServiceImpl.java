package com.ams.service.impl;

import com.ams.dao.UserMapper;
import com.ams.entities.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public Page<UserInfo> queryList() {
        Page<UserInfo> page = new Page<UserInfo>();
        UserInfo user = new UserInfo();
        user.setAge(20);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("age", 20);
        List<UserInfo> result = userDao.userQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveUser(UserInfo user) {
        userDao.insertUser(user);
    }

    @Override
    public UserInfo getUserByLogin(String userName, String password) {
        return null;
    }

}
