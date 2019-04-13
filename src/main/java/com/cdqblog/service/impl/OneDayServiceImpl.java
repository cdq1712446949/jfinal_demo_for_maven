package com.cdqblog.service.impl;

import com.cdqblog.dao.OneDayWordDAO;
import com.cdqblog.model.Onedayword;
import com.cdqblog.service.OneDayWordService;
import com.jfinal.aop.Inject;

public class OneDayServiceImpl implements OneDayWordService {

    @Inject(OneDayWordDAO.class)
    private OneDayWordDAO oneDayWordDAO;

    @Override
    public Onedayword getNewOneDayWord() {
        return oneDayWordDAO.getNewOneDayWord();
    }
}
