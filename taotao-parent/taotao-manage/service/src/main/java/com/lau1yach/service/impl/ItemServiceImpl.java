package com.lau1yach.service.impl;

import com.github.pagehelper.PageHelper;
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
 * @date 10/5/2018  11:17 AM
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

        //1.设置分页的信息使用pagehelper
        if (page == null) {
            page = 1;
        }

        if (rows == null) {
            rows = 30;
        }
        PageHelper.startPage(page,rows);

        //2.注入mapper


        //3.创建example对象 不需要设置查询条件
        TbItemExample example = new TbItemExample();

        //4.根据mapper调用查询所有数据
        List<TbItem> list = tbItemMapper.selectByExample(example);

        //5.获取到分页的信息
        PageInfo<TbItem> info = new PageInfo<>(list);

        //6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());

        //7.返回
        return result;
    }
}
