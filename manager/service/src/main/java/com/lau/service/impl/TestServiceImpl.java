package com.lau.service.impl;

import com.lau.service.TestService;
import com.lau.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyhpl
 * @Title: TestServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/8/2018  1:36 PM
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
