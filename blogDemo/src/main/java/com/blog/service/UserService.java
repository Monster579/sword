package com.blog.service;

import com.blog.entity.User;

/**
 * Created by ASUS on 2019/8/19.
 */
public interface UserService {

    int regist(User user);

    User login(String email, String phone ,String password);

    User findByName(String name);

    void update(User user);

    void delete(Integer id);


}
