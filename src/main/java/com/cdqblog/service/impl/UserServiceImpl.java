package com.cdqblog.service.impl;

import com.cdqblog.dao.UserDAO;
import com.cdqblog.model.User;
import com.cdqblog.service.UserService;
import com.jfinal.plugin.activerecord.Page;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(){
        this.userDAO=new UserDAO();
    }

    @Override
    public Page<User> getUsersByPn(int pn) {
        return userDAO.getUsersByPn(pn);
    }

    @Override
    public boolean changeUserStatus(long id,int status) {
        return userDAO.changeUserStatus(id,status);
    }

    @Override
    public boolean deleteUser(long id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean login(User user) {
        if (userDAO.login(user)==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean regist(User user) {
        if (userDAO.findUserByPhone(user.getPhone())==null){
            return userDAO.addUser(user);
        }else {
            return false;
        }
    }

    @Override
    public User findUserByPhone(String phone) {
        return userDAO.findUserByPhone(phone);
    }
}
