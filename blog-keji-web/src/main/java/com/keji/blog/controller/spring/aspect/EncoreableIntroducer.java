package com.keji.blog.controller.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by wb-ny291824 on 2017/8/21.
 *
 * @DeclareParents注解，将Encoreable 接口引入到Performancebean中
 *      value ： 指定了那种类型的bean要引入该接口。这里就是所有实现Performance的类型，+好表示的是Performance的所有子类型，而不是其本身
 *      defaultImpl 指定了为引入功能提供的实现类。
 *      该注解的静态属性指明了要引入的接口
 *      需要在spring 中声明为bean
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.keji.blog.controller.spring.aspect.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
