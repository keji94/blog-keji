package com.keji.blog.service.content;

import com.keji.blog.pojo.TbContentCategory;
import com.keji.blog.result.BaseResult;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/1.
 */
public interface ContentService {

    BaseResult<List<TbContentCategory>> showCategory();
}
