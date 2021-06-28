package com.hust.edu.services.impl;

import com.hust.edu.dao.UserDao;
import com.hust.edu.entity.Page;
import com.hust.edu.entity.User;
import com.hust.edu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 业务层实现类
     * 1、加工数据
     * 2、调用数据访问层
     * @param
     * @return
     */


    @Override
    public int add(User user) {
        //若密码加密，请在此处完成。
        return userDao.add(user);
    }

    @Override
    public int del(int id) {
        return userDao.del(id);
    }

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectByLogNameAndPwd(String loginName, String pwd) {
        return userDao.selectByLogNameAndPwd(loginName, pwd);
    }

    @Override
    public List<User> selectByPage(Page<User> page) {
        return userDao.selectByPage(page);
    };

}
