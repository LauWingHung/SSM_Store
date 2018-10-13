package com.lau.controller;

import com.lau.common.entity.LauResult;
import com.lau.content.service.ContentService;
import com.lau.entity.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lyhpl
 * @Title: ContentController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/11/2018  4:50 PM
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/content/save")
    @ResponseBody
    public LauResult CreateContent(TbContent content){
        LauResult result = contentService.createConent(content);
        return result;
    }

}
