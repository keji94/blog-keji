package com.keji.blog.controller.DesignModes.Singleton;

/**
 * Created by wb-ny291824 on 2017/8/18.
 * 双检索+volatile关键字实现单例模式。个人认为最好的单例模式
 *
 * 为什么使用volatile关键字修饰instance?
 *     因为instance = new SingletonDemo2()并不是一个原子操作。在JVM中他分为这样的三步：
 *      1.为SingletonDemo2对象分配内存 memory = allocate()
 *      2.将分配的内存指向该对象instance = memory
 *      3.调用SingletonDemo2的构造方法，创建对象并指向instance.
 */
public class SingletonDemo2 {
    private static volatile SingletonDemo2 instance;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (instance == null){
            synchronized (SingletonDemo2.class){
                if (instance == null) {
                    instance = new SingletonDemo2();
                }
            }
        }
        return instance;
    }

}
