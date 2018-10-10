package com.lau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyhpl
 * @Title: IndexController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/10/2018  9:37 AM
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
