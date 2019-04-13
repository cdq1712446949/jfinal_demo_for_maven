package com.cdqblog.service.impl;

import com.cdqblog.dao.ManagerDAO;
import com.cdqblog.model.Manager;
import com.cdqblog.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDAO managerDAO;

    public ManagerServiceImpl(){
        this.managerDAO=new ManagerDAO();
    }

    @Override
    public boolean admin_login(Manager manager) {
        return managerDAO.admin_login(manager);
    }
}
