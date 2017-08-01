package com.keji.blog.service.backstage.impl;

import com.keji.blog.mapper.TbContentCategoryMapper;
import com.keji.blog.pojo.TbContentCategory;
import com.keji.blog.pojo.TbContentCategoryExample;
import com.keji.blog.result.EasyUiTreeNode;
import com.keji.blog.service.backstage.BackstageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */
@Service
public class BackstageServiceImpl implements BackstageService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    public List<EasyUiTreeNode> getContentCategoryList(Long parentId) {
        //取查询参数parentID
        List<TbContentCategory> list = getTbContentCategoriesByParentId(parentId);
        List<EasyUiTreeNode> easyUiTreeNodeList = new ArrayList<EasyUiTreeNode>();
        for (TbContentCategory category : list) {
            EasyUiTreeNode node = new EasyUiTreeNode();
            node.setId(category.getId());
            node.setText(category.getName());
            node.setState(category.getIsParent()?"closed":"open");
            easyUiTreeNodeList.add(node);
        }
        return easyUiTreeNodeList;
    }

    private List<TbContentCategory> getTbContentCategoriesByParentId(Long id) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        return tbContentCategoryMapper.selectByExample(example);
    }
}
