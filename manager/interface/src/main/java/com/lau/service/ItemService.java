package com.lau.service;

import com.lau.common.entity.EasyUIDataGridResult;
import com.lau.common.entity.LauResult;
import com.lau.entity.TbItem;

public interface ItemService {

    //根据当前的页码和每页 的行数进行分页查询

    EasyUIDataGridResult getItemList(Integer page,Integer rows);

    //添加商品基本数据和描述数据

    LauResult saveItem(TbItem item,String desc);
}
