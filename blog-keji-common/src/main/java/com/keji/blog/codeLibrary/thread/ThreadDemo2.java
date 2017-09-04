package com.keji.blog.codeLibrary.thread;

/**
 * Created by wb-ny291824 on 2017/8/15.
 * 实现Runnable接口
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread thread = new Thread(demo2);
        thread.start();
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

class Demo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
