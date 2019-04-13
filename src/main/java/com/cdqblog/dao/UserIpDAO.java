package com.cdqblog.dao;

import com.cdqblog.model.Userip;
import com.jfinal.plugin.activerecord.Page;

public class UserIpDAO {

    //分页获取userip列表
    public Page<Userip> getUserIp(int pn){
        return Userip.dao.paginate(pn,10,"select * ","from userip");
    }

    public boolean addUserIp(Userip userip){
        return userip.save();
    }

}
