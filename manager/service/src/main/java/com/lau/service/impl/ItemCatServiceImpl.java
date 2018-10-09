package com.lau.service.impl;

import com.lau.common.entity.EasyUITreeNode;
import com.lau.entity.TbItemCat;
import com.lau.entity.TbItemCatExample;
import com.lau.mapper.TbItemCatMapper;
import com.lau.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lau.entity.TbItemCatExample.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyhpl
 * @Title: ItemCatServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/9/2018  9:32 AM
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {
        //根据parentId查询节点列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        Criteria criteria = example.createCriteria();
        //select * from tbitemcat where parentid = 1
        criteria.andParentIdEqualTo(parentId);
        //执行查询list<tbitemcat>
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        //转换成需要的数据类型List<EasyUITreeNode>
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbItemCat cat : list ) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(cat.getId());
            node.setText(cat.getName());
            //"open",closed
            node.setState(cat.getIsParent()?"closed":"open");
            nodes.add(node);
        }
        return nodes;
    }
}
