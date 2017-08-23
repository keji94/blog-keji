package com.keji.blog.controller.spring.aspect;

/**
 * Created by wb-ny291824 on 2017/8/21.
 * 表演接口。
 * 切点表达式：execution(* com.keji.blog.controller.spring.aspect.Performance.perform(..)) && within(com.keji.*)
 *          execution ：在方法执行时触发
 *          *         ：不关心方法返回值的类型
 *          ...Performance.perform ： 指定了方法的全限定类名和方法名。
 *          (..)    :  表示的是方法的任意参数，即任何重载的perform()方法
 *          &&      ： 连接execution()和with()指示器 表示 and ；也可以用||表示or ；用!表示非.在spring的xml配置中，使用and表示&& or表示|| not表示!
 *          within() ：指示器，用来限定匹配的切点范围。上面的表达式表示匹配com.keji包
 *          bean()  :  spring引入的bean（）指示器 。!bean('beanName') bean('beanName')来限制匹配的bean ；
 *                      execution(* com.keji.blog.controller.spring.aspect.Performance.perform(..)) and bean('woodstock')
 *
 */
public interface Performance {
    public void perform();
}
