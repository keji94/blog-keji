package com.keji.blog.service.backstage;

import com.keji.blog.pojo.TbContentCategory;
import com.keji.blog.pojo.TbContentPicture;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.EasyUiTreeNode;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */
public interface BackstageService {
    List<EasyUiTreeNode> getContentCategoryList(Long parentId);

    BaseResult<TbContentCategory> createCategory(long parentId, String name);

    BaseResult<Integer> updateCategory(long id, String name);

    BaseResult<Integer> deleteCategory(long id);

    BaseResult addPic(TbContentPicture tbContentPicture);

    BaseResult getArticleById(Long articleId);

    BaseResult picList(int page, int rows);
}
