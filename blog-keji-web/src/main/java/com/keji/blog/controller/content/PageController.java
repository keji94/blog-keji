package com.keji.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ny291824 on 2017/7/31.
 */
@Controller
@RequestMapping("/content")
public class PageController {

    @RequestMapping("/index")
    public String showIndex() {
        return "/content/index";
    }


    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return "/content/"+page;
    }
}
