package com.lau.service;

import com.lau.common.entity.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {

    List<EasyUITreeNode> getCatList(long parentId);
}
