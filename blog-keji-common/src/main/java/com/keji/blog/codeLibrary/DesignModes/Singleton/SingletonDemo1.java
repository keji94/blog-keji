package com.keji.blog.codeLibrary.DesignModes.Singleton;


/**
 * Created by wb-ny291824 on 2017/8/18.\
 * 使用静态内部类实现单例模式
 */
public class SingletonDemo1 {
    private SingletonDemo1() {

    }

    //静态内部类在使用的时候才会加载，并且只会加载一次
    private static class singletonHolder{
        private static final SingletonDemo1 instance;

        static {
            instance = new SingletonDemo1();
        }
    }

    public static SingletonDemo1 getInstance() {
        return singletonHolder.instance;
    }
}
