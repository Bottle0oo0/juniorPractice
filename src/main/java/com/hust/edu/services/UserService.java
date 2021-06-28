package com.hust.edu.services;

import com.hust.edu.entity.Page;
import com.hust.edu.entity.User;

import java.util.List;

/**
 * 业务层接口
 */
public interface UserService {
    public int add(User user);
    public int del(int id);
    public User selectById(int id);
    public List<User> selectAll();
    public User selectByLogNameAndPwd(String loginName,String pwd);
    public List<User> selectByPage(Page<User> page);
}
