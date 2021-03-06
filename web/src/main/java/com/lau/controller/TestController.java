package com.lau.controller;

import com.lau.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lyhpl
 * @Title: TestController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/8/2018  1:42 PM
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;
    @RequestMapping("/test/queryNow")
    @ResponseBody
    public String queryNow(){
        return testService.queryNow();
    }

}
