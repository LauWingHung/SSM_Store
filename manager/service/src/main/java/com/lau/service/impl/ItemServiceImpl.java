package com.lau.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.common.entity.EasyUIDataGridResult;
import com.lau.entity.TbItem;
import com.lau.entity.TbItemExample;
import com.lau.mapper.TbItemMapper;
import com.lau.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyhpl
 * @Title: ItemServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/8/2018  4:18 PM
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //设置分页的信心使用pagehelper
        if (page==null) {
            page=1;
        }
        if (rows==null) {
            rows=30;
        }
        PageHelper.startPage(page,rows);
        //创建一个example对象,不需要查询条件
        TbItemExample example = new TbItemExample();
        //根据mapper调用查询所有数据的方法
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //获取分页的信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        //封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        //返回
        return result;
    }
}
