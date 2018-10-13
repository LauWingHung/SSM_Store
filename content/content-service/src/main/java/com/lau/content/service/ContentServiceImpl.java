package com.lau.content.service;

import com.lau.common.entity.LauResult;
import com.lau.common.utils.JsonUtils;
import com.lau.content.jedis.JedisClient;
import com.lau.entity.TbContent;
import com.lau.entity.TbContentExample;
import com.lau.entity.TbContentExample.*;
import com.lau.mapper.TbContentMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lyhpl
 * @Title: ContentServiceImpl
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/11/2018  4:43 PM
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY;

    @Override
    public LauResult createConent(TbContent content) {
        //补全属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //插入数据
        tbContentMapper.insert(content);

        //缓存同步
        jedisClient.hdel(CONTENT_KEY,content.getCategoryId().toString());
        return LauResult.ok();
    }

    @Override
    public List<TbContent> getContentList(long cid) {
        //查询缓存
        try {
            String json = jedisClient.hget(CONTENT_KEY,cid+"");
            //判断json是否为空
            if (StringUtils.isNotBlank(json)){
                //把json转换成list
                List<TbContent> list = JsonUtils.jsonToList(json,TbContent.class);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //根据cid查询内容列表
        TbContentExample example = new TbContentExample();
        //设置查询条件
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        //执行查询
        List<TbContent> list = tbContentMapper.selectByExample(example);

        //向缓存中添加数据
        try {
            jedisClient.hset(CONTENT_KEY,cid+"",JsonUtils.objectToJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
