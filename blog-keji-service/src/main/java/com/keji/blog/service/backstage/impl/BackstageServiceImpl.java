package com.keji.blog.service.backstage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constans.BlogError;
import com.keji.blog.mapper.TbContentArticleMapper;
import com.keji.blog.mapper.TbContentCategoryMapper;
import com.keji.blog.mapper.TbContentPictureMapper;
import com.keji.blog.pojo.*;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.EasyUiTreeNode;
import com.keji.blog.service.backstage.BackstageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */
@Service
@Slf4j
public class BackstageServiceImpl implements BackstageService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Resource
    private TbContentPictureMapper tbContentPictureMapper;
    @Resource
    private TbContentArticleMapper tbContentArticleMapper;

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


    public BaseResult<TbContentCategory> createCategory(long parentId, String name) {
        //填充category属性
        TbContentCategory category = initCategory(parentId, name);
        int i = 0;
        try {
            i = tbContentCategoryMapper.insert(category);
        } catch (Exception e) {
            log.error("tbContentCategoryMapper.insert is error ",e);
            return BaseResult.makeFail();
        }
        if (i==1){
            //插入成功,更新父节点
            TbContentCategory parentNode = tbContentCategoryMapper.selectByPrimaryKey(parentId);
            if (!parentNode.getIsParent()) {
                BaseResult<Integer> result = updateParentNode(parentNode, parentId);
                if (result.getStatus() != 200){
                    return BaseResult.makeFail();
                }
            }
            return BaseResult.ok(category);
        }else {
            return BaseResult.makeFail();
        }
    }


    public BaseResult<Integer> updateCategory(long id, String name) {
        TbContentCategory category = null;
        int count = 0;
        try {
            category = tbContentCategoryMapper.selectByPrimaryKey(id);
            category.setName(name);
            count = tbContentCategoryMapper.updateByPrimaryKey(category);
        } catch (Exception e) {
            log.error("tbContentCategoryMapper.selectByPrimaryKey is error",e);
            return BaseResult.makeFail();
        }
        if (count==1){
            return BaseResult.ok(1);
        }else {
            return BaseResult.makeFail();
        }
    }


    public BaseResult<Integer> deleteCategory(long id) {
        /**
         * 1.根据id查询isParent
         * 2.是-->查询子节点,判断是否是parent   递归
         * 3.否-->删除,查询父节点下面是否还有其他子节点.
         * 4.有-->不做操作
         * 5.无-->更改isParent
         */
        TbContentCategory category = tbContentCategoryMapper.selectByPrimaryKey(id);
        if (category == null){
            log.error("TbContentCategory is null...Id = "+id);
            return BaseResult.makeFail();
        }

        deleteAllNodes(category,id);
        return BaseResult.ok();
    }

    private BaseResult<Integer> deleteAllNodes(TbContentCategory category,Long id) {
        if (category.getIsParent()){//是父节点,递归删除
            List<TbContentCategory> list = getTbContentCategoriesByParentId(id);
            //根据parentID查询所有的子节点.
            for (TbContentCategory contentCategory : list) {
                Long contentCategoryId = contentCategory.getId();
                deleteAllNodes(contentCategory,contentCategoryId);
            }
            //删除当前节点
            tbContentCategoryMapper.deleteByPrimaryKey(id);
        }else {//不是父节点,根据id删除
            Long parentId = category.getParentId();
            tbContentCategoryMapper.deleteByPrimaryKey(id);
            //查询该节点的父节点下是否还有其他节点,如果没有,更改isParent状态
            List<TbContentCategory> categoryList = getTbContentCategoriesByParentId(parentId);
            if (categoryList.size() == 0){//没有其他节点
                //获得父节点
                TbContentCategory parentCategory = tbContentCategoryMapper.selectByPrimaryKey(parentId);
                parentCategory.setIsParent(false);
                //更新
                tbContentCategoryMapper.updateByPrimaryKey(parentCategory);
            }
        }
        return BaseResult.ok();
    }

    private TbContentCategory initCategory(long parentId, String name) {
        TbContentCategory category = new TbContentCategory();
        category.setIsParent(false);
        category.setParentId(parentId);
        category.setName(name);
        category.setCreated(new Date());
        category.setUpdated(new Date());
        //id
        //status
        category.setStatus(1);
        //sort_order
        category.setSortOrder(1);
        return category;
    }

    private BaseResult updateParentNode(TbContentCategory parentNode,long parentId) {
        parentNode.setIsParent(true);
        try {
            tbContentCategoryMapper.updateByPrimaryKey(parentNode);
        } catch (Exception e) {
            log.error("tbContentCategoryMapper.updateByPrimaryKey is error",e);
            return BaseResult.makeFail(BlogError.updateFailed);
        }
        return BaseResult.ok(BlogError.updateSuccess);
    }


    //=============================================================图片轮播部分
    public BaseResult addPic(TbContentPicture tbContentPicture) {
        int i = 0;
        try {
            i = tbContentPictureMapper.insert(tbContentPicture);
        } catch (Exception e) {
            log.error("tbContentPictureMapper.insert is error...",e);
            return BaseResult.makeFail("tbContentPictureMapper.insert is error...");
        }
        if (i == 1){
            return BaseResult.ok(i);
        }else {
            return BaseResult.makeFail();
        }
    }

    public BaseResult getArticleById(Long articleId) {
        TbContentArticleExample example = new TbContentArticleExample();
        TbContentArticleExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId);

        List<TbContentArticle> list = null;
        try {
            list = tbContentArticleMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("tbContentPictureMapper.selectByExample is error...",e);
            return BaseResult.makeFail();
        }

        if (list != null && list.size() == 1 ){
            return BaseResult.ok(list.size());
        }else {
            return BaseResult.makeFail();
        }
    }

    public BaseResult picList(int page, int rows) {
        PageHelper.startPage(page, rows);
        TbContentPictureExample example = new TbContentPictureExample();
        List<TbContentPicture> list = null;
        try {
            list = tbContentPictureMapper.selectByExample(example);

        } catch (Exception e) {
            log.error("tbContentPictureMapper.selectByExample(example)",e);
            return BaseResult.makeFail();
        }
        //去分页信息
        PageInfo<TbContentPicture> pageInfo = new PageInfo<TbContentPicture>(list);
        BaseResult<List<TbContentPicture>> result = BaseResult.ok(list);
        result.setPageInfo(pageInfo.getTotal(), list);
        return result;
    }
}
