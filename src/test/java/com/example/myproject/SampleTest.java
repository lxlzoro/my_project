package com.example.myproject;

import com.example.myproject.dao.TPersonInfoDao;
import com.example.myproject.entity.TPersonInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {
    @Autowired
    private TPersonInfoDao tPersonInfoDao;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<TPersonInfo> TPersonInfoList = tPersonInfoDao.selectList(null);
        System.out.println(TPersonInfoList.size());
    }
}
