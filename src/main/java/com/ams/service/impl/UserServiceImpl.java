package com.ams.service.impl;

import com.ams.dao.UserMapper;
import com.ams.entities.UserInfo;
import com.ams.pagination.Page;
import com.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Evan on 2016/3/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public Page<UserInfo> queryList(Page<UserInfo> page) {
        if (page == null) {
            page = new Page<UserInfo>();
        }
        List<UserInfo> result = userDao.userQueryPage(page);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveUser(UserInfo user) {
        userDao.insertUser(user);
    }

}
