package com.lau.common.entity;

import java.io.Serializable;

/**
 * @author lyhpl
 * @Title: LauResult
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/9/2018  11:12 AM
 */
public class LauResult implements Serializable {
    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    //构建其他状态的taotaoresult对象
    public static LauResult build(Integer status, String msg, Object data) {
        return new LauResult(status, msg, data);
    }

    public static LauResult ok(Object data) {
        return new LauResult(data);
    }

    public static LauResult ok() {
        return new LauResult(null);
    }

    public LauResult() {

    }

    public static LauResult build(Integer status, String msg) {
        return new LauResult(status, msg, null);
    }

    public LauResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LauResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}



