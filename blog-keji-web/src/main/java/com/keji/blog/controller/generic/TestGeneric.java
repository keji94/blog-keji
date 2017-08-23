package com.keji.blog.controller.generic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */

@Controller
public class TestGeneric {

    @RequestMapping("/testGeneric")
    public void testGeneric() {
        List<String> listString = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();
        System.out.println(listInt.getClass() == listInt.getClass());    //结果为true,原因是泛型擦除。
    }
}
