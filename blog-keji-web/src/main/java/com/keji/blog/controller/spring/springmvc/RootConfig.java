package com.keji.blog.controller.spring.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by wb-ny291824 on 2017/8/25.
 */

@Configuration
@ComponentScan(basePackages = {"com.keji.blog.controller.spring.springmvc.spitter"},
                excludeFilters={
                    @ComponentScan.Filter(type= FilterType.ANNOTATION,value=EnableWebMvc.class)
        })
public class RootConfig {
}
