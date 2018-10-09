package com.lau.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.common.entity.EasyUIDataGridResult;
import com.lau.common.entity.LauResult;
import com.lau.common.utils.IDUtils;
import com.lau.entity.TbItem;
import com.lau.entity.TbItemDesc;
import com.lau.entity.TbItemExample;
import com.lau.mapper.TbItemDescMapper;
import com.lau.mapper.TbItemMapper;
import com.lau.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
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

    @Override
    public LauResult saveItem(TbItem item, String desc) {
        //生成商品的id
        long itemId = IDUtils.genItemId();
        //补全item其他属性
        item.setId(itemId);
        item.setCreated(new Date());
        //1-正常,2-下架,3-删除
        item.setStatus((byte) 1);
        item.setUpdated(item.getCreated());
        //插入到item表    商品的基本信息表
        tbItemMapper.insertSelective(item);
        //补全商品描述中的属性
        TbItemDesc desc1 = new TbItemDesc();
        desc1.setItemDesc(desc);
        desc1.setItemId(itemId);
        desc1.setCreated(item.getCreated());
        desc1.getUpdated(item.getCreated());
        //插入商品的描述数据
        tbItemDescMapper.insertSelective(desc1);
        return LauResult.ok();
    }
}
