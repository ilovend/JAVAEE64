package com.itheima.thread.test5;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run......");
        Thread thread = Thread.currentThread();
        System.out.println("MyThread:" + thread.getName());
    }
}
