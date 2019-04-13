package com.cdqblog.service.impl;

import com.cdqblog.dao.TestDAO;
import com.cdqblog.model.Test;
import com.cdqblog.service.TestService;

public class TestServiceImpl implements TestService {

    private TestDAO dao;

    public TestServiceImpl(){
        dao=new TestDAO();
    }

    @Override
    public Test getPage(int id) {
        return dao.getPage(id);
    }
}
