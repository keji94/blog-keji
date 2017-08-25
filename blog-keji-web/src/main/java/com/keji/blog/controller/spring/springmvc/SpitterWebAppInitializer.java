package com.keji.blog.controller.spring.springmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by wb-ny291824 on 2017/8/24.
 */
public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {//这个方法指定的配置类，由ContextLoaderListener加载其他bean
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//指定配置类,这个方法指定的配置类，有DispathcherServlet加载包含web的组件bean
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //将DispatherServlet映射到"/"
        return new String[]{"/"};
    }
}
