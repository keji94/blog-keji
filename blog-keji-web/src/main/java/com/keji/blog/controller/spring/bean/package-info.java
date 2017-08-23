/**
 * Created by wb-ny291824 on 2017/8/21.
 * Spring对bean的装配有三种形式
 * 1.在xml中进行显示配置
 * 2.在java中进行显示配置
 * 3.隐式的bean发现机制和自动装配
 *      3.1 spring从两个角度来实现自动化装配：
 *              1.组件扫描：spring自动发现应用上下文所创建的bean
 *              2.自动装配：spring自动满足bean之间的依赖。为了声明进行自动装配，可以借助Spring的@Autowired注解
 *
 * 选择：
 *      尽可能的选择自动配置机制----》类型安全比xml更加强大的javaConfig--->xml
 */
package com.keji.blog.controller.spring.bean;