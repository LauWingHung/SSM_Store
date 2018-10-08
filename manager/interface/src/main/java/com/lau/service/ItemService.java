package com.lau.service;

import com.lau.common.entity.EasyUIDataGridResult;

public interface ItemService {
    EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
