package com.lau1yach.service;
import com.lau1yach.common.entity.EasyUIDataGridResult;

/**
 * @author lyhpl
 */
public interface ItemService {
    //    根据当前的页码和每页的行数进行分页查询

    EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
