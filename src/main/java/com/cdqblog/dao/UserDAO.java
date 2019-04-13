package com.cdqblog.dao;

import com.cdqblog.model.User;
import com.jfinal.plugin.activerecord.Page;

public class UserDAO {

    //通过分页方式获取用户列表
    public Page<User> getUsersByPn(int pn) {
        return User.dao.paginate(pn, 10, "select * ", "from user");
    }

    //修改用户状态
    public boolean changeUserStatus(long id, int status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        return user.update();
    }

    //删除用户
    public boolean deleteUser(long id){
        return User.dao.deleteById(id);
    }

    //用户登录
    public User login(User user){
        User user1=null;
        user1=User.dao.findFirst("select * from user where phone=? and password=? and status=?",user.getPhone(),user.getPassword(),0);
        return user1;
    }

    //用户注册功能
    public boolean addUser(User user){
        return  user.save();
    }

    //通过手机号查询user
    public User findUserByPhone(String phone){
        User user=null;
        user=User.dao.findFirst("select * from user where phone=?",phone);
        return user;
    }

}
