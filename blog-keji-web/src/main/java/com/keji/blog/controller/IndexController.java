package com.keji.blog.controller;

import com.keji.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */
@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"/","/test"})
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "username" ,defaultValue = "")String username,@RequestParam("password")String password){
       int flag =  userService.check(username,password);
        return null;
    }
}
