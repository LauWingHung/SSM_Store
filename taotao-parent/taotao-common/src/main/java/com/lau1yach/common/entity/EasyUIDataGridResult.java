package com.lau1yach.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author lyhpl
 * @Title: EasyUIDataGridResult
 * @ProjectName SSM_Store
 * @Description: TODO   展示数据的实体,包括商品的实体
 * @date 10/5/2018  11:06 AM
 */
public class EasyUIDataGridResult implements Serializable {
    private Integer total;

    private List rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
