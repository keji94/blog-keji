package com.keji.blog.controller.backstage;


import com.keji.blog.pojo.BlogCategory;
import com.keji.blog.pojo.BlogPicture;
import com.keji.blog.result.BaseResult;
import com.keji.blog.result.EasyUiTreeNode;
import com.keji.blog.service.backstage.BackstageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 * 后台系统的Controller
 */
@Controller
@Slf4j
@RequestMapping("/backstage")
public class BackstageController {

    @Autowired
    private BackstageService backstageService;

    @RequestMapping("/index")
    public String showIndex() {
        return "/backstage/index";
    }

    /**
     * 后台页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return "/backstage/"+page;
    }

    /**
     * @return
     */
    @RequestMapping("/category/list")
    @ResponseBody
    public List<EasyUiTreeNode> getContentCatList(@RequestParam(value = "id",defaultValue = "0")long parentId){
        List<EasyUiTreeNode> catList = null;
        try {
            catList = backstageService.getContentCategoryList(parentId);
        } catch (Exception e) {
            log.error("iContentCategoryService.getContentCatList is error"+e);
            return null;
        }
        if (catList.size()>0){
            return catList;
        }else {
            log.error("catList.size=0");
            return null;
        }
    }

    @RequestMapping("/category/create")
    @ResponseBody
    public BaseResult<BlogCategory> createCategory(long parentId, String name){
        BaseResult<BlogCategory> result = null;
        try {
            result = backstageService.createCategory(parentId, name);
        } catch (Exception e) {
            log.error("iContentCategoryService.createCategory",e);
            return BaseResult.makeFail();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/category/update")
    public BaseResult<Integer> updateCategory(long id,String name){

        BaseResult<Integer> result = null;
        try {
            result = backstageService.updateCategory(id, name);
        } catch (Exception e) {
            log.error("iContentCategoryService.updateCategory is error",e);
            return BaseResult.makeFail();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/category/delete")
    public BaseResult<Integer> deleteCategory(long id){
        BaseResult<Integer> result = backstageService.deleteCategory(id);
        return result;
    }


    @ResponseBody
    @RequestMapping("/picSave")
    public BaseResult picAdd(BlogPicture blogPicture) {
        if (blogPicture == null){
            return BaseResult.makeFail("参数错误");
        }

        //根据Id查询关联的文章是否存在，不存在return fail
        BaseResult queryArticleResult = backstageService.getArticleById(blogPicture.getArticleId());

        if (queryArticleResult.getStatus() == 500){
            return BaseResult.makeFail("Id为"+blogPicture.getArticleId()+"的文章不存在");
        }

        BaseResult result = null;
        try {
             result = backstageService.addPic(blogPicture);
        } catch (Exception e) {
            log.error("backstageService.addPic(blogPicture) is error...",e);
            return BaseResult.makeFail("系统错误");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/listPic")
    public BaseResult picList(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "20") int rows ) {
        BaseResult result = null;
        try {
            result = backstageService.picList(page,rows);
        } catch (Exception e) {
            log.error("backstageService.picList() is error...",e);
            return BaseResult.makeFail("系统错误");
        }
        return result;
    }



}
