package com.lau.controller;

import com.lau.common.entity.EasyUITreeNode;
import com.lau.common.entity.LauResult;
import com.lau.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lyhpl
 * @Title: ContentCategoryController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/10/2018  11:23 AM
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public LauResult createContentCategory(Long parentId,String name){
        LauResult result = contentCategoryService.createContentCategory(parentId,name);
        return result;
    }
}
