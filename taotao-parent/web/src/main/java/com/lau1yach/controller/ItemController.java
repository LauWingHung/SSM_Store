package com.lau1yach.controller;

import com.lau1yach.common.entity.EasyUIDataGridResult;

import com.lau1yach.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lyhpl
 * @Title: ItemController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/5/2018  11:28 AM
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    //url:/item/list
    //method:get
    //参数:page,rows
    //返回值:json

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        //1.引用服务
        //2.注入服务
        //3.调用服务的方法
        return itemService.getItemList(page,rows);
    }

}
