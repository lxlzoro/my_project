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

    /**
     * 使用mybatis-plus默认
     * @return
     */
    public List<TPersonInfo> getPersonInfoList() {
        List<TPersonInfo> personInfoList = tPersonInfoDao.selectList(null);
        return personInfoList;
    }

    /**
     * 使用自己写的
     * @return
     */
    public List<TPersonInfo> getPersonInfos(){
       List<TPersonInfo> personInfoList = tPersonInfoDao. findPersons();
        return personInfoList;
    }

}
