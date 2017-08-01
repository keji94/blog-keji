package com.keji.blog.service.backstage;

import com.keji.blog.result.EasyUiTreeNode;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */
public interface BackstageService {
    List<EasyUiTreeNode> getContentCategoryList(long parentId);
}
