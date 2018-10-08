package com.lau1yach.service.impl;

import com.github.pagehelper.PageInfo;
import com.lau1yach.common.entity.EasyUIDataGridResult;
import com.lau1yach.entity.TbItem;
import com.lau1yach.entity.TbItemExample;
import com.lau1yach.mapper.TbItemMapper;
import com.lau1yach.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyhpl
 * @Title: ItemServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/8/2018  8:53 AM
 */
@Service
public class ItemServiceImpl implements ItemService {
    //注入mapper

    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //设置分信息,使用pagehelper
        if (page==null) {
            page=1;
        }
        if (rows==null) {
            rows=30;
        }
        //创建example对象
        TbItemExample example = new TbItemExample();
//        根据mapper调用查询所有数据的方法
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //设置分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
//        封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        return result;
    }
}
