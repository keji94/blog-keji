package com.keji.blog.codeLibrary.thread;

/**
 * Created by wb-ny291824 on 2017/8/15.
 * 继承Thread类
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

class Demo extends Thread{
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
