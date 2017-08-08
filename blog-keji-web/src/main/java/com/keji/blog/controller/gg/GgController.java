package com.keji.blog.controller.gg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ny291824 on 2017/8/8.
 */
@Controller
@RequestMapping("/gg")
public class GgController {

    @RequestMapping("/showGg")
    public String showGg() {
        return "/gg/gg";
    }
}
