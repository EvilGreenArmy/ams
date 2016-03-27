package com.ams.service.admin.impl;

import com.ams.dao.admin.UserMapper;
import com.ams.entities.admin.UserInfo;
import com.ams.pagination.Page;
import com.ams.security.PwdEncoder;
import com.ams.service.admin.UserService;
import com.ams.util.Constant;
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

    @Autowired
    private PwdEncoder pwdEncoder;

    private static final String salt = "googlebaidu";
    private static final String MD5_KEY = "amsMd5";
    @Override
    public Page<UserInfo> queryList() {
        Page<UserInfo> page = new Page<UserInfo>();
        UserInfo user = new UserInfo();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        paramMap.put("age", 20);
        List<UserInfo> result = userDao.userQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveUser(UserInfo user) {
        String password = pwdEncoder.encodePassword(Constant.DEFAULT_PASSWORD, salt);
        user.setPassword(password);
        userDao.insertUser(user);
    }

    @Override
    public UserInfo getUserByLogin(String userName, String password) {
        UserInfo user = new UserInfo();
        user.setAcctName(userName);
        List<UserInfo> list = userDao.getUser(user);
        UserInfo loginUser = null;
        if(list != null && list.size() > 0) {
            UserInfo temp = list.get(0);
            String dbpassword = temp.getPassword();
            if (pwdEncoder.isPasswordValid(dbpassword, password, salt)) {
                // 登陆成功
                loginUser = temp;
            }
        }
        return loginUser;
    }
    @Override
    public boolean checkAcctName(String acctName) {
        UserInfo user = new UserInfo();
        user.setAcctName(acctName);
        List<UserInfo> list = userDao.getUser(user);
        if(list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
