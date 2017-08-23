package com.keji.blog.controller.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wb-ny291824 on 2017/8/18.
 * 配置类：作用和xml中的组件扫描类似
 * ComponentScan:启动组件扫描，默认扫描和配置类相同的包以及所有子包。查找带有@Component注解的类
 *      效果等同于xml中的
 *     <context:compinent-scan base-package="soundsystem"/>
 *
 * 设置组件扫描的基础包：
 *  1.@ComponentScan(basePackages = "packagename")  置顶包的名称,可以是数组的形式{"p1","p2"}
 *  2.@ComponentScan(basePackageClasses = CDPlayer.class)  指定包中所包含的类或者接口，可以是数组的形式。这些类所在的包会被作为组件扫描的基础包。
 *          可以创建一个空表机接口MarkerInterface
 *
 * @  Configuration注解：
 *      该注解标注在类上的作用类似于xml配置中的<beans></beans>,作用为配置spring容器应用上下文。
 *      <beans>
 *          <bean></bean>
 *      </beans>
 *
 *
 */

@Configuration
//@ComponentScan
public class CDPlayerConfig {

    /**
     * 使用JavaConfig 来配置bean而不使用@ComponentSacn注解。
     * @Bean注解告诉Spring这个方法会返回一个对象，该对象注册为Spring应用上下文的bean
     *      默认情况下bean的ID和方法名一样。自定义名字的话，使用name属性。
     *
     *      再次强调一遍，带有@Bean注解的方法可以采用任何必要的Java功能来产生bean实例。构造器和Setter方法都只是两个简单的样例。
     * @return
     */
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPepper() {
        return new SgtPeppers();
    }
    /**
     * Javaconfig实现注入
     * 因为sgtPepper()上面加了@Bean注解，所以Spring会拦截所有对它的调用，并确保直接返回该方法所创建的bean，而不是每次都
     *      对其进行实际的调用。
     */
    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPepper());
    }

    /**
     * 在一组CD中随机选择一个CD来播放,这个就是Java配置强大的地方了。
     */
    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        } else if (choice == 1) {
            return new WhiteAlbum();
        } else if (choice == 2) {
            return new HardDaysNight();
        } else {
            return new Revoler();
        }
    }


}
