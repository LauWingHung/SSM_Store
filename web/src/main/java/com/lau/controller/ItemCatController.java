package com.lau.controller;

import com.lau.common.entity.EasyUITreeNode;
import com.lau.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lyhpl
 * @Title: ItemCatController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/9/2018  9:53 AM
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
    //url:'/item/cat/list',
    //参数：id
    //返回值：json
    //method:get post
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.引入服务
        //2.注入服务
        //3.调用方法
        List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }


}
