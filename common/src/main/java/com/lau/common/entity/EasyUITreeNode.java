package com.lau.common.entity;

import java.io.Serializable;

/**
 * @author lyhpl
 * @Title: EasyUITreeNode
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/9/2018  9:25 AM
 */
public class EasyUITreeNode implements Serializable {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
