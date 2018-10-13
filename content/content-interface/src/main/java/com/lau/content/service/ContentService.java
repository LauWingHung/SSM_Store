package com.lau.content.service;

import com.lau.common.entity.LauResult;
import com.lau.entity.TbContent;

import java.util.List;

/**
 * @author lyhpl
 * @Title: ContentService
 * @ProjectName SSM_Store
 * @Description: TODO
 * @date 10/11/2018  4:42 PM
 */
public interface ContentService {
    LauResult createConent(TbContent content);

    List<TbContent> getContentList(long cid);
}
