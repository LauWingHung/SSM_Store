package com.lau.controller;

import com.lau.common.entity.EasyUIDataGridResult;
import com.lau.common.entity.LauResult;
import com.lau.common.utils.JsonUtils;
import com.lau.entity.TbItem;
import com.lau.service.ItemService;
import com.lau.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyhpl
 * @Title: ItemController
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/8/2018  4:28 PM
 */
@Controller
public class ItemController {
    @Value("${LAU_IMAGE_SERVER_URL}")
    private String LAU_IMAGE_SERVER_URL;

    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){

        return itemService.getItemList(page,rows);
    }

    @RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String uploadImage(MultipartFile multipartFile){
        try {
            //获取源文件的扩展名
            String originalFilename = multipartFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            //获取文件的字节数组
            byte[] bytes = multipartFile.getBytes();
            // 通过fastdfsclient的方法上传图片（参数要求有 字节数组 和扩展名 不包含"."）
            FastDFSClient client = new FastDFSClient("classpath:astdfs.conf");
            //获取返回值
            String string = client.uploadFile(bytes,extName);
            //拼接完整的URL
            String path = LAU_IMAGE_SERVER_URL+string;
            //成功是设置map
            Map<String,Object> map = new HashMap<>();
            map.put("error",0);
            map.put("url",path);
            //返回map
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            //失败时,设置map
            Map<String,Object> map = new HashMap<>();
            map.put("error",1);
            map.put("message","上传失败");
            return JsonUtils.objectToJson(map);
        }

    }

    //添加商品的方法
    //url:：/item/save
    //参数：tbitem ,desc
    //返回值 json
    //method:post

    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public LauResult saveItem(TbItem item,String desc){
        return itemService.saveItem(item,desc);
    }

    public static void main(String[] args){
        float aa = 130f;
        //单位是yuan
        double a = 130d;
        double num = 3;
        System.out.println(aa * num);
        System.out.println(a * num);
    }
}

