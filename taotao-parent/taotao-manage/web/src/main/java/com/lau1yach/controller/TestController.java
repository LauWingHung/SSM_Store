package com.lau1yach.controller;

import com.lau1yach.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lyhpl
 * @Title: TestController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 9/30/2018  5:47 PM
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;
    /**
     * 测试dubbo配置是否正常
     * @return
     */
    @RequestMapping("/test/queryNow")
    @ResponseBody
    public String queryNow(){
        return testService.queryNow();
    }
}
