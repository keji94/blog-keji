package com.keji.blog.controller.content;

import com.keji.blog.service.content.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by keji on 2017/7/31.
 */
@Controller
@RequestMapping("/content/category")
public class CategoryController {

    @Autowired
    private ContentService contentService;

    /**
     * TODO 完成result对象，以及后台分类的管理。
     * @return
     */
    @RequestMapping("/list")
    public String showCategoryList() {
//        contentService.showCategoryList();
        return null;
    }

}
