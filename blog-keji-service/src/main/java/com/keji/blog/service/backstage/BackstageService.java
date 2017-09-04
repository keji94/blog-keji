package com.keji.blog.service.backstage;

import com.keji.blog.dataobject.BlogCategory;
import com.keji.blog.dataobject.BlogPicture;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.EasyUiTreeNode;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */
public interface BackstageService {
    List<EasyUiTreeNode> getContentCategoryList(Long parentId);

    BaseResult<BlogCategory> createCategory(long parentId, String name);

    BaseResult<Integer> updateCategory(long id, String name);

    BaseResult<Integer> deleteCategory(long id);

    BaseResult addPic(BlogPicture blogPicture);

    BaseResult getArticleById(Long articleId);

    BaseResult picList(int page, int rows);
}
