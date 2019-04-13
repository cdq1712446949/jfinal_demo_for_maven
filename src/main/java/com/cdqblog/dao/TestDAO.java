package com.cdqblog.dao;

import com.cdqblog.model.Test;

public class TestDAO {

    public Test getPage(int id){
        return Test.dao.findById(id);
    }

}
