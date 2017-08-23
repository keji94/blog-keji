package com.keji.blog.controller.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wb-ny291824 on 2017/8/18.
 * jdk5以后，可以通过实现callable接口的方式来实现多线程
 *  call方法可以在创建线程执行结束时产生一个返回值。
 *
 *  Future<T> submit(Callable<T> task); 该方法返回一个Future结果。
 */
public class ThreadDemo4 implements Callable<Integer>{
    private int upperBounds;

    public ThreadDemo4(int upperBounds) {
        this.upperBounds = upperBounds;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}

class Test{
    public static void main(String[] args) throws Exception{
        List<Future<Integer>> list =  new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new ThreadDemo4((int) (Math.random() * 100))));
        }
        int sum = 0;
        for (Future<Integer> future : list) {
            sum += future.get();
        }
        System.out.println(sum);
    }
}

