package com.keji.blog.controller.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wb-ny291824 on 2017/8/21.
 *
 * 1.@Autowired注解使用在构造器上表示自动装配，当spring创建CDplayer的时候
 *      会通过这个构造器实例化，并且传入一个CompactDisc类型的bean。
 *
 * 2. 实际上@Autowired注解不仅可以声明在构造器上，而是可以声明在类的任何方法上，
 *  spring会尽可能的满足方法参数上声明的依赖，这时会出现以下三种情况：
 *      1.假如有且只有一个满足要求的bean，那么这个bean就会被装配进来。
 *      2.假如有多个bean满足依赖关系，会抛出异常，表明没有明确指定要选择哪个bean进行装配
 *      3.如果没有匹配的bean，那么会抛出一个异常。这时可以将Autowired的required属性设为false,默认是true.
 *          如果这样，需要注意null值检查，以免引发空指针异常。
 * 3.@Autowired注解是spring特有的，可以使用java的@Inject注解代替。
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd ;

    @Autowired(required = false)
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }
    @Override
    public void play() {
        cd.play();
    }
}
