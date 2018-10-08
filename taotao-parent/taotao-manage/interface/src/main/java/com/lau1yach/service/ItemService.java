package com.lau1yach.service;

import com.lau1yach.common.entity.EasyUIDataGridResult;

public interface ItemService {

    EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
