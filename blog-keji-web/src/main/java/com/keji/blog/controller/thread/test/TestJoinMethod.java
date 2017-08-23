package com.keji.blog.controller.thread.test;

/**
 * Created by wb-ny291824 on 2017/8/20.
 */
public class TestJoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            public void run() {
                System.out.println("Thread1 is running");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Thread1 is stoped");
                }
                super.run();
            }
        };
         Thread thread2 = new Thread(){
            public void run() {
                System.out.println("Thread2 is running");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Thread2 is stoped");
                }
                super.run();
            }
        };
         Thread thread3 = new Thread(){
            public void run() {
                System.out.println("Thread3 is running");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Thread3 is stoped");
                }
                super.run();
            }
        };

         thread.start();
        thread.join();
        thread2.start();
        thread2.join();
        thread3.start();
         thread3.join();
    }
}
