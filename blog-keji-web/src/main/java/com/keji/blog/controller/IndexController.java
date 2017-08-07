package com.keji.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/test"})
    public String showIndex(){
        return "index";
    }

}
