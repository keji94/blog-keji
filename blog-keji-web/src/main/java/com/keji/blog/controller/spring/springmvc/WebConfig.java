package com.keji.blog.controller.spring.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by wb-ny291824 on 2017/8/25.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.keji.blog.controller.spring.springmvc.spitter.web")     //启动组件扫描，扫描spitter.web包来查找组件
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver vireResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //配置JSP试图解析器
        resolver.setPrefix("/WEB-INF/vires/");  //前缀
        resolver.setSuffix(".jsp");         //后缀
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        //要求DispatherServlet对静态资源的请求转发到Servlet容器中的默认的Servlet上，而不是使用DispatcherServelt本身来处理
        configurer.enable();
    }
}
