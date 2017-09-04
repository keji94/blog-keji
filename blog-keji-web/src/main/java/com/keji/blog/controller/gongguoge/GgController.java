package com.keji.blog.controller.gongguoge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ny291824 on 2017/8/8.
 * 功过格
 */
@Controller
@RequestMapping("/gongguoge")
public class GgController {

    @RequestMapping("/showGg")
    public String showGg() {
        return "/gongguoge/gongguoge";
    }
}
