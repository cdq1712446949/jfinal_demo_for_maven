package com.cdqblog.service;

import com.cdqblog.model.Userip;
import com.jfinal.plugin.activerecord.Page;

public interface UserIpService {

    //获取userip列表
    Page<Userip> getUserIp(int pn);

    //添加userip记录
    boolean addUserIp(Userip userip);

}
