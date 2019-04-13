package com.cdqblog.service;

import com.cdqblog.model.User;
import com.jfinal.plugin.activerecord.Page;

public interface UserService {

    //已分页方式获取用户列表
    public Page<User> getUsersByPn(int pn);

    //修改用户状态
    public boolean changeUserStatus(long id,int status);

    //删除用户
    public boolean deleteUser(long id);

    //用户登录
    boolean login(User user);

    //用户注册
    boolean regist(User user);

    //通过手机号查询user
    User findUserByPhone(String phone);

}
