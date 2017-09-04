package com.keji.blog.service.content.impl;

import com.keji.blog.dao.BlogCategoryMapper;
import com.keji.blog.dataobject.BlogCategory;
import com.keji.blog.dataobject.BlogCategoryExample;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.content.ContentService;
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
    private BlogCategoryMapper blogCategoryMapper;

    public BaseResult<List<BlogCategory>> showCategory() {
        BlogCategoryExample example = new BlogCategoryExample();
        BlogCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdNotEqualTo(1L);
        List<BlogCategory> list = null;
        try {
            list = blogCategoryMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("blogCategoryMapper.selectByExample is error...",e);
            return BaseResult.makeFail();
        }
        return BaseResult.ok(list);
    }

}
