package com.keji.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ny291824 on 2017/7/31.
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @RequestMapping("/index")
    public String index() {
        return "/content/index";
    }

    @RequestMapping("/category/show")
    public String show() {
        return "/content/category-list";
    }
}
