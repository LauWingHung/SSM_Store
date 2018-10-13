package com.lau.content.service;

import com.lau.common.entity.EasyUITreeNode;
import com.lau.common.entity.LauResult;
import com.lau.entity.TbContentCategory;
import com.lau.entity.TbContentCategoryExample;
import com.lau.entity.TbContentCategoryExample.Criteria;
import com.lau.mapper.TbContentCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lyhpl
 * @Title: ContentCategoryServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/10/2018  10:58 AM
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentId) {
        //取查询参数ID: parentId
        //根据parentId 查询tb_content_category,查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        //设置查询条件
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        //得到List<TbContentCategory>
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        //把列表转换成List<EasyUITreeNode>
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list ) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加到列表
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public LauResult createContentCategory(Long parentId, String name) {
        //接收两个参数,parentId和name
        //向tb_content_category表插入数据
        //创建一个tbContentCategory对象
        TbContentCategory tbContentCategory = new TbContentCategory();
        //补全TbContentCategory对象的属性
        tbContentCategory.setIsParent(false);
        tbContentCategory.setName(name);
        tbContentCategory.setParentId(parentId);
        //排列序号,表示同级类目的展现持续,如数值相等则按名称次序排列,取值范围:大于零的整数
        tbContentCategory.setSortOrder(1);
        //状态,可选值1(正常),2(删除)
        tbContentCategory.setStatus(1);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //向tb_content_category标配插入数据
        contentCategoryMapper.insert(tbContentCategory);
        //判断父节点isparent是否为true,不是true需要给为true
        TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parentNode.getIsParent()){
            parentNode.setIsParent(true);
        }
        //需要主键返回,
        //返回LauResult,其中包装TbContentCategory对象
        return LauResult.ok(tbContentCategory);
    }
}
