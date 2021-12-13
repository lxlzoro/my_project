package com.example.myproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myproject.entity.TPersonInfo;

import java.util.List;

public interface TPersonInfoDao extends BaseMapper<TPersonInfo> {

    List<TPersonInfo> findPersons();

}
