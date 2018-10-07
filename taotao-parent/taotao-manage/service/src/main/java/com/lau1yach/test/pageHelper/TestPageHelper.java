package com.lau1yach.test.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau1yach.entity.TbItem;
import com.lau1yach.entity.TbItemExample;
import com.lau1yach.mapper.TbItemMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lyhpl
 * @Title: TestPageHelper
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/4/2018  10:31 AM
 */
public class TestPageHelper {
    @Test
    public void testPage(){
//        初始化spring
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:spring-context.xml");
//        获取mapper代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);

//设置分页
//        三行  紧跟着的第一个查询才会被分页
        PageHelper.startPage(1,3);

//        调用mapper方法查询数据
//        设置查询条件使用
        TbItemExample example = new TbItemExample();
//        select *from tb_item;
        List<TbItem> list = itemMapper.selectByExample(example);
        List<TbItem> list2 = itemMapper.selectByExample(example);

//        取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);

        System.out.println("第一个分页list的集合长度"+list.size());
        System.out.println("第二分页list2的集合长度"+list2.size());
//        遍历数据
        System.out.println("查询的总记录数:"+info.getTotal());
        for (TbItem tbItem :list2 ) {
            System.out.println(tbItem.getId()+">>>>>名称"+tbItem.getTitle());
        }
    }

}
