package com.cdqblog.dao;

import com.cdqblog.model.Manager;

public class ManagerDAO {

    //管理员登陆方法
    public boolean admin_login(Manager manager) {
        Manager temp = new Manager();
        temp = Manager.dao.findFirst("select * from manager where userName=? and password=?",manager.getUserName(),manager.getPassword());
        if (temp == null) {
            return false;
        } else {
            return true;
        }
    }

}
