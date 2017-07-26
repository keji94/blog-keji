package com.keji.blog.controller;

import com.xiaoleilu.hutool.convert.Convert;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-ny291824 on 2017/7/25.
 */
@Controller
public class TestController {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/genhtml")
    @ResponseBody
    public String genHtml() throws Exception{
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = configuration.getTemplate("hello.ftl");
        Map dataModel = new HashMap<String,String>();
        dataModel.put("hello", "1000");
        FileWriter writer = new FileWriter(new File("D:/spring-freemarker.html"));
        template.process(dataModel, writer);
        writer.close();
        return "ok";
    }
}
