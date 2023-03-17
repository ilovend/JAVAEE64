package com.itheima.thread.test2;

/**
 * 编写任务类的方式实现多线程
 * MyThread extends Thread:线程类和任务强绑定在一起的
 * MYRunnable implements Runnable:线程和任务分开,组合的时候更灵活
 *
 * @author ilovend
 * @date 2023/03/17
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
//            程序执行的时长
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
