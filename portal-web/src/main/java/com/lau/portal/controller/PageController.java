package com.lau.portal.controller;

import com.lau.common.utils.JsonUtils;
import com.lau.content.service.ContentService;
import com.lau.entity.TbContent;
import com.lau.portal.entity.Ad1Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyhpl
 * @Title: PageController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/11/2018  5:36 PM
 */
@Controller
public class PageController {
    @Autowired
    private ContentService contentService;

    @Value("${AD1_CATEGORY_ID}")
    private Long AD1_CATEGORY_ID;

    @Value("${AD1_HEIGHT}")
    private String AD1_HEIGHT;
    @Value("${AD1_HEIGHT_B}")
    private String AD1_HEIGHT_B;
    @Value("${AD1_WIDTH}")
    private String AD1_WIDTH;
    @Value("${AD1_WIDTH_B}")
    private String AD1_WIDTH_B;


    //展示首页

    @RequestMapping("/index")
    public String showIndex(Model model){
        //1.引入服务
        //2.注入服务
        //3.调用方法 tbcontent的列表
        List<TbContent> list = contentService.getContentList(AD1_CATEGORY_ID);
        //转换成ad1node列表
        List<Ad1Node> nodes = new ArrayList<>();
        for (TbContent tbContent : list ) {
            Ad1Node node = new Ad1Node();
            node.setAlt(tbContent.getSubTitle());
            node.setHref(tbContent.getUrl());
            node.setSrc(tbContent.getPic());
            node.setSrcB(tbContent.getPic2());
            node.setHeight(AD1_HEIGHT);
            node.setHeightB(AD1_HEIGHT_B);
            node.setWidth(AD1_WIDTH);
            node.setWidthB(AD1_WIDTH_B);
            nodes.add(node);
        }
        //转换成JSON数据
        String json = JsonUtils .objectToJson(nodes);
        //将JSON数据设置到request域（Model）
        model.addAttribute("content_ad1",json);
        return "index";
    }
}
