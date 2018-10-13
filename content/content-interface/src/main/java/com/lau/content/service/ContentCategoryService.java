package com.lau.content.service;

import com.lau.common.entity.EasyUITreeNode;
import com.lau.common.entity.LauResult;

import java.util.List;

public interface ContentCategoryService {
    //通过节点的id查询该节点的子节点列表

    List<EasyUITreeNode> getContentCategoryList(long parentId);

    //添加内容分类 parentId 父节点id,name新增节点的名称

    LauResult createContentCategory(Long parentId,String name);
}
