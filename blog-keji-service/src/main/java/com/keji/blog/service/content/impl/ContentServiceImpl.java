package com.keji.blog.service.content.impl;

import com.keji.blog.mapper.TbContentCategoryMapper;
import com.keji.blog.pojo.TbContentCategory;
import com.keji.blog.pojo.TbContentCategoryExample;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.content.ContentService;
import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/1.
 */
@Service
@Slf4j
public class ContentServiceImpl implements ContentService {

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    public BaseResult<List<TbContentCategory>> showCategory() {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(1L);
        List<TbContentCategory> list = null;
        try {
            list = tbContentCategoryMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("tbContentCategoryMapper.selectByExample is error...",e);
            return BaseResult.makeFail();
        }
        return BaseResult.ok(list);
    }

}
