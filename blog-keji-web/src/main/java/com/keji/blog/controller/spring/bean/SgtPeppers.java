package com.keji.blog.controller.spring.bean;

import org.springframework.stereotype.Component;

/**
 * Created by wb-ny291824 on 2017/8/18.
 * component注解将该类声明一个组件类，并告知Spring为这个类创建bean
 * 给Bean起名字：
 *  1.@Component("beanName")
 *  2.@Named注解("beanName")  --Java依赖注入规范，Spring支持将@Named作为Component注解的替代方案。两者有点差异
 *      但是大多数情况下可以互相替代，只是Named不想Component那么明晰的表明是做什么的，不推荐使用。
 */
@Component("sgtPeppers")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int num) {

    }
}
