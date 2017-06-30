package com.keji.blog.controller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wb-ny291824 on 2017/6/30.
 */

@Controller
public class HelloVelocity {

    @RequestMapping("/testVelocity")
    public String testVelocity() throws IOException {

        return "HelloVelocity";
    }
}
