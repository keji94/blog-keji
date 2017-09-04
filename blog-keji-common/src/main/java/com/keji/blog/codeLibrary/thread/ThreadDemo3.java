package com.keji.blog.codeLibrary.thread;

/**
 * Created by wb-ny291824 on 2017/8/15.
 * 匿名内部类实现多线程
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        new Thread("线程1"){
            public void run() {
                for (int i = 0; i < 40; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        }.start();

        Runnable r = new Runnable(){
            public void run() {
                for (int x = 0; x < 40; x++) {
                    System.out.println(Thread.currentThread().getName()+" "+x);
                }
            }
        };
        new Thread(r,"线程2").start();
    }
}
