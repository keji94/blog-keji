package com.keji.blog.controller.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

/**
 * Created by wb-ny291824 on 2017/8/21.
 * 观众。
 * 从演出来看，观众很重要，但是并不是必须的。所以将观众定义为一个切面。
 *
 * 定义好切面之后，还需要为注解启动自动代理。
 * 如果使用JavaConfig的话，可以在配置类的类级别上通过使用EnableAspectJ-AutoProxy注解启用自动注解
 * 如果使用xml装备bean，需要使用<aop:aspectj-autoproxy>元素。
 */
<<<<<<< HEAD
@Aspect//使用Aspect注解标注，表明Audience不仅仅是一个POJO，还是一个切面
=======
@Aspect
>>>>>>> origin/master
public class Audience {

    /**
     * 除开注解，Audience依然是一个POJO，和其他JAVa类没有区别，只不过通过注解表明会作为切面使用。
     * @return
     */
    @Bean
    public Audience audience() {
        return new Audience();
    }

    /**
     * 将切点抽取出来，公用。
     * 这里的performance 里面的内容是什么并不重要，可以是空的，因为这只是给@pointCut一个依附
     */
    @Pointcut("execution(* com.keji.blog.controller.spring.aspect.Performance.perform(..))")
    public void performance() {

    }

    /**
     * 看演出前手机静音
     */
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silencing cell phones");
    }

    /**
     * 看演出前找到座位
     */
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    /**
     * 演出成功完成之后鼓掌喝彩
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAp CLAP");
    }

    /**
     * 演出出现问题，要求退款
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    /**
     * 环绕通知
     * @param joinPoint
     *
     * 使用joinPoint.proceed()方法来调用被通知的方法，就是执行被环绕的方法。
     * 如果不调用proceed()，那么被通知的方法将被阻塞.
     *
     * 环绕通知对比单独使用前置通知和后置通知的优点：
     *      前置通知和后置想要共享变量只能通过定义成员变量。
     *      比如在这里需要记录每个观众观看演出的时间，使用前置后置的方式就是在成员变量保存开始时间，在前置通知中记录开始时间
     *          并在后置通知中报告表演消耗的时间。但是Audience是单例的，这样存在线程安全问题。
     *
     *       如果使用环绕通知的话，因为前置和后置都是在一个方法内实现，不需要保存成员变量
     *
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAp CLAP");
        } catch (Throwable throwable) {
            System.out.println("Demanding a refund");
        }
    }

}
