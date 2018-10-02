package com.lau1yach.service.impl;
import com.lau1yach.mapper.TestMapper;
import com.lau1yach.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyhpl
 * @Title: TestServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 9/30/2018  5:42 PM
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public String queryNow() {

        return testMapper.queryNow();
    }

}
