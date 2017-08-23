package com.keji.blog.controller.thread;

import java.util.Random;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class DeadLock {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();
    public static void main(String[] args) {
        //创建线程任务类对象
        ThreadTask task = new ThreadTask();
        //创建两个线程
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        //启动线程
        t1.start();
        t2.start();
    }

}

class ThreadTask implements Runnable {
    int x = new Random().nextInt(1);//0,1
    //指定线程要执行的任务代码
    @Override
    public void run() {
        while(true){
            if (x%2 ==0) {
                //情况一
                synchronized (DeadLock.lockA) {
                    System.out.println("if-LockA");
                    synchronized (DeadLock.lockB) {
                        System.out.println("if-LockB");
                        System.out.println("if大口吃肉");
                    }
                }
            } else {
                //情况二
                synchronized (DeadLock.lockB) {
                    System.out.println("else-LockB");
                    synchronized (DeadLock.lockA) {
                        System.out.println("else-LockA");
                        System.out.println("else大口吃肉");
                    }
                }
            }
            x++;
        }
    }
}

