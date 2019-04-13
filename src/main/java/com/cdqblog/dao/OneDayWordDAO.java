package com.cdqblog.dao;

import com.cdqblog.model.Onedayword;

public class OneDayWordDAO {

    //选取最新的每日一句
    public Onedayword getNewOneDayWord(){
        return Onedayword.dao.findFirst("select * from onedayword order by id desc");
    }

}
