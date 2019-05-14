package lee.sword.service;

import lee.sword.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2019/5/10.
 */
@Service
public interface UserService {

    // 用户注册
    int regist(User user);

    // 登录
    void login(User user);

    // 根据用户邮箱查询用户信息
    User findUserByEmail(String email);

    // 根据用户手机号查询用户信息
    User findUserByPhone(String phone);

    // 根据ID查询用户信息
    User findUserById(Integer id);

    // 删除用户信息
    void delete(User user);

    // 更新用户信息
    void update(User user);

}
