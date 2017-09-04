package com.keji.blog.codeLibrary.thread;

import java.util.List;
import java.util.Vector;

/**
 * Created by wb-ny291824 on 2017/8/15.
 * 线程池的简单实现
 */
public class ThreadPool {
    private static ThreadPool instance = null;
    //空闲的线程队列
    private List<JThread> idleThreads;
    //已有的线程总数
    private int threadCounter = 0;
    private Boolean isShunDown = false;
    public ThreadPool() {
        //初始化空闲线程队列容量为5
        this.idleThreads = new Vector<JThread>(5);
        this.threadCounter = 0;
    }
    private static class SingleTonHolder {
        private static ThreadPool threadPool = new ThreadPool();
    }
    /*单例获得线程池实例*/
    public static ThreadPool getInstance() {
        return SingleTonHolder.threadPool;
    }
    public int getThreadCounter() {
        return threadCounter;
    }

    /**
     * 将线程放入池中，回收线程
     */
    protected synchronized void repool(JThread repoolingThread) {
        if (!isShunDown) {
            idleThreads.add(repoolingThread);
        } else {
            repoolingThread.shutDown();
        }
    }
    /**
     * 停止池中所有线程
     */
    public synchronized void shutDownAll() {
        this.isShunDown = true;
        for (JThread jThread : idleThreads) {
            jThread.shutDown();
        }
    }

    /**
     * 执行线程任务
     */
    public synchronized void execute(Runnable target) {
        this.isShunDown = false;
        JThread jThread = null;
     /*如果池中有空余线程，直接使用该线程*/
        if (idleThreads.size() > 0) {
            jThread = idleThreads.get(idleThreads.size() - 1);
            //将该线程从池中移除
            idleThreads.remove(jThread);
            //立即执行该任务
            jThread.setTarget(target);
        }
     /*没有空闲线程，创建新线程*/
        else {
            threadCounter++;
            //创建线程
            jThread = new JThread(target, "JThread:" + threadCounter, ThreadPool.this);
            jThread.start();
        }
    }
}

class JThread extends Thread{
    //线程池
    private ThreadPool threadPool;
    //任务
    private Runnable target;
    private boolean isShutDown = false;
    private boolean isIdle = false;
    public JThread(Runnable target, String name, ThreadPool threadPool) {
        super(name);
        this.target = target;
        this.threadPool = threadPool;
    }
    public Runnable getTarget() {
        return target;
    }
    public boolean isIdle() {
        return isIdle;
    }

    @Override
    public void run() {
        //只要没有关闭，则一直不结束该线程
        while (!isShutDown) {
            isIdle = false;
            if (null != target) {
                //执行任务，注意这里调用的是run()，而不是start()
                target.run();
            }
            //任务结束，闲置状态
            isIdle = true;
            try {
                threadPool.repool(JThread.this);
                synchronized (this) {
                    //线程空闲，等待新的任务到来
                    wait();
                }
            } catch (InterruptedException e) {
            }
            isIdle = false;
        }
    }

    public synchronized void setTarget(Runnable target) {
        this.isShutDown = false;
        this.target = target;
        //设置任务之后，通知run方法，开始执行任务
        notifyAll();
    }

    /**
     * 关闭线程
     */
    public synchronized void shutDown() {
        this.isShutDown = true;
        notifyAll();
    }
}
