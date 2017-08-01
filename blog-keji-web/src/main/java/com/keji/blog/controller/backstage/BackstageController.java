package com.keji.blog.controller.backstage;

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
    private BackstageService contentService;

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
            catList = contentService.getContentCategoryList(parentId);
        } catch (Exception e) {
            log.error("iContentCategoryService.getContentCatList is error"+e);
        }
        if (catList.size()>0){
            return catList;
        }else {
            log.error("catList.size=0");
            return null;
        }
    }

}
