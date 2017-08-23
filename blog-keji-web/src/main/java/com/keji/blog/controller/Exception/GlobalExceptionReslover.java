package com.keji.blog.controller.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wb-ny291824 on 2017/8/21.
 * springmvc全局异常处理
 */
public class GlobalExceptionReslover implements HandlerExceptionResolver{

    Logger logger = LoggerFactory.getLogger(GlobalExceptionReslover.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //写日志文件
        logger.error("系统发生异常",ex);
        //发邮件、发短信
        //展示错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "系统发生异常，请稍后重试");
        modelAndView.setViewName("/error/exception");
        return modelAndView;
    }
}
