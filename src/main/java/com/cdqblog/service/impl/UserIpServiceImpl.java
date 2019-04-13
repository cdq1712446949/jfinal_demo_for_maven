package com.cdqblog.service.impl;

import com.cdqblog.dao.UserIpDAO;
import com.cdqblog.model.Userip;
import com.cdqblog.service.UserIpService;
import com.jfinal.plugin.activerecord.Page;

public class UserIpServiceImpl implements UserIpService {

    private UserIpDAO userIpDAO;

    public UserIpServiceImpl(){
        this.userIpDAO=new UserIpDAO();
    }

    @Override
    public Page<Userip> getUserIp(int pn) {
        return userIpDAO.getUserIp(pn);
    }

    @Override
    public boolean addUserIp(Userip userip) {
        return userIpDAO.addUserIp(userip);
    }
}
