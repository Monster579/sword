package com.blog.service.impl;

import com.blog.DAO.mapper.UserMapper;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by ASUS on 2019/8/19.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int regist(User user) {
        int id = userMapper.insert(user);
        return id;
    }

    @Override
    public User login(String email, String phone, String password) {
        User user = new User();
        if(StringUtils.isBlank(phone)) {
            user.setPhone(phone);
        }else if(StringUtils.isBlank(email)){
            user.setEmail(email);
        }
        user.setPhone(phone);
        user.setPassword(password);

        return userMapper.selectOne(user);
    }

    @Override
    public User findByName(String name) {
        User user = new User();
        user.setNickName(name);
        user = userMapper.selectOne(user);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(Integer id) {
        User user = new User();
        user.setId(id);
        userMapper.delete(user);
    }
}
