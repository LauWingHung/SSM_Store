package com.lau.controller;

import com.lau.common.entity.EasyUIDataGridResult;
import com.lau.service.ItemService;
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
 * @date 10/8/2018  4:28 PM
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){

        return itemService.getItemList(page,rows);
    }

}
