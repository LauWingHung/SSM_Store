package com.lau1yach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyhpl
 * @Title: PageController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/4/2018  9:39 AM
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String ShowIndex(){
        return "index";
    }

//    按URL显示页面

    @RequestMapping("/{page}")
    public String ShowPage(@PathVariable String page){
        return page;
    }

////   跳转到新增商品页面/item-add
//
//@RequestMapping("/item-add")
//    public String ItemAddPage(){
//        return "item-add";
//}
////   跳转到查询商品页面/item-list
//
//    @RequestMapping("/item-list")
//    public String ItemListPage(){
//        return "item-list";
//    }
////   跳转到规格参数页面/item-param-list
//
//    @RequestMapping("/item-param-list")
//     public String ItemParamListPage(){
//        return "item-param-list";
//    }
//
////   跳转到内容分类管理页面/content-category
//
//    @RequestMapping("/content-category")
//    public String ContentCategoryPage(){
//        return "content-category";
//    }
////   跳转到内容管理<页面/content
//
//    @RequestMapping("/content")
//    public String ContentPage(){
//        return "content";
//    }
}
