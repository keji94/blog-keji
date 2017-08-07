package com.keji.blog.service.backstage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constans.BlogError;
import com.keji.blog.mapper.*;
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
    private BlogCategoryMapper blogCategoryMapper;
    @Resource
    private BlogPictureMapper blogPictureMapper;
    @Resource
    private BlogArticleMapper blogArticleMapper;

    public List<EasyUiTreeNode> getContentCategoryList(Long parentId) {
        //取查询参数parentID
        List<BlogCategory> list = getBlogCategoryCategoriesByParentId(parentId);
        List<EasyUiTreeNode> easyUiTreeNodeList = new ArrayList<EasyUiTreeNode>();
        for (BlogCategory category : list) {
            EasyUiTreeNode node = new EasyUiTreeNode();
            node.setId(category.getCategoryId());
            node.setText(category.getCategoryName());
            node.setState(category.getCategoryIsparent()?"closed":"open");
            easyUiTreeNodeList.add(node);
        }
        return easyUiTreeNodeList;
    }

    private List<BlogCategory> getBlogCategoryCategoriesByParentId(Long id) {
        BlogCategoryExample example = new BlogCategoryExample();
        BlogCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategpryParentidEqualTo(id);
        return blogCategoryMapper.selectByExample(example);
    }


    public BaseResult<BlogCategory> createCategory(long parentId, String name) {
        //填充category属性
        BlogCategory category = initCategory(parentId, name);
        int i = 0;
        try {
            i = blogCategoryMapper.insert(category);
        } catch (Exception e) {
            log.error("blogCategoryMapper.insert is error ",e);
            return BaseResult.makeFail();
        }
        if (i==1){
            //插入成功,更新父节点
            BlogCategory parentNode = blogCategoryMapper.selectByPrimaryKey(parentId);
            if (!parentNode.getCategoryIsparent()) {
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
        BlogCategory category = null;
        int count = 0;
        try {
            category = blogCategoryMapper.selectByPrimaryKey(id);
            category.setCategoryName(name);
            count = blogCategoryMapper.updateByPrimaryKey(category);
        } catch (Exception e) {
            log.error("blogCategoryMapper.selectByPrimaryKey is error",e);
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
        BlogCategory category = blogCategoryMapper.selectByPrimaryKey(id);
        if (category == null){
            log.error("category is null...Id = "+id);
            return BaseResult.makeFail();
        }

        deleteAllNodes(category,id);
        return BaseResult.ok();
    }

    private BaseResult<Integer> deleteAllNodes(BlogCategory category,Long id) {
        if (category.getCategoryIsparent()){//是父节点,递归删除
            List<BlogCategory> list = getBlogCategoryCategoriesByParentId(id);
            //根据parentID查询所有的子节点.
            for (BlogCategory blogCategory : list) {
                Long blogCategoryId = blogCategory.getCategoryId();
                deleteAllNodes(blogCategory,blogCategoryId);
            }
            //删除当前节点
            blogCategoryMapper.deleteByPrimaryKey(id);
        }else {//不是父节点,根据id删除
            Long parentId = category.getCategpryParentid();
            blogCategoryMapper.deleteByPrimaryKey(id);
            //查询该节点的父节点下是否还有其他节点,如果没有,更改isParent状态
            List<BlogCategory> categoryList = getBlogCategoryCategoriesByParentId(parentId);
            if (categoryList.size() == 0){//没有其他节点
                //获得父节点
                BlogCategory parentCategory = blogCategoryMapper.selectByPrimaryKey(parentId);
                parentCategory.setCategoryIsparent(false);
                //更新
                blogCategoryMapper.updateByPrimaryKey(parentCategory);
            }
        }
        return BaseResult.ok();
    }

    private BlogCategory initCategory(long parentId, String name) {
        BlogCategory category = new BlogCategory();
        category.setCategoryIsparent(false);
        category.setCategpryParentid(parentId);
        category.setCategoryName(name);
        category.setCategoryCreated(new Date());
        category.setCategoryUpdated(new Date());
        //id
        //status
        category.setCategoryStatus(false);
        //sort_order
        category.setCategoryOrdernum(1);
        return category;
    }

    private BaseResult updateParentNode(BlogCategory parentNode,long parentId) {
        parentNode.setCategoryIsparent(true);
        try {
            blogCategoryMapper.updateByPrimaryKey(parentNode);
        } catch (Exception e) {
            log.error("blogCategoryMapper.updateByPrimaryKey is error",e);
            return BaseResult.makeFail(BlogError.updateFailed);
        }
        return BaseResult.ok(BlogError.updateSuccess);
    }


    //=============================================================图片轮播部分
    public BaseResult addPic(BlogPicture blogPicture) {
        int i = 0;
        try {
            i = blogPictureMapper.insert(blogPicture);
        } catch (Exception e) {
            log.error("blogPictureMapper.insert is error...",e);
            return BaseResult.makeFail("blogPictureMapper.insert is error...");
        }
        if (i == 1){
            return BaseResult.ok(i);
        }else {
            return BaseResult.makeFail();
        }
    }

    public BaseResult getArticleById(Long articleId) {
        BlogArticleExample example = new BlogArticleExample();
        BlogArticleExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId);

        List<BlogArticle> list = null;
        try {
            list = blogArticleMapper.selectByExample(example);
        } catch (Exception e) {
            log.error("blogArticleMapper.selectByExample is error...",e);
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
        BlogPictureExample example = new BlogPictureExample();
        BlogPictureExample.Criteria criteria = example.createCriteria();
        criteria.andPictureStatusEqualTo(false);
        List<BlogPicture> list = null;
        try {
            list = blogPictureMapper.selectByExample(example);

        } catch (Exception e) {
            log.error("blogPictureMapper.selectByExample(example)",e);
            return BaseResult.makeFail();
        }
        //去分页信息
        PageInfo<BlogPicture> pageInfo = new PageInfo<BlogPicture>(list);
        BaseResult<List<BlogPicture>> result = BaseResult.ok(list);
        result.setPageInfo(pageInfo.getTotal(), list);
        return result;
    }
}
