package com.keji.blog.codeLibrary.thread.test;

import com.keji.blog.codeLibrary.thread.ThreadPool;

/**
 * Created by wb-ny291824 on 2017/8/15.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                /*执行任务*/
            }
        });
    }
}
