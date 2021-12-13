package com.example.myproject.service;

import com.example.myproject.dao.TPersonInfoDao;
import com.example.myproject.entity.TPersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TPersonInfoService {

    @Autowired
    private TPersonInfoDao tPersonInfoDao;

    public List<TPersonInfo> getPersonInfoList() {
        List<TPersonInfo> personInfoList = tPersonInfoDao.selectList(null);
        return personInfoList;
    }

}
