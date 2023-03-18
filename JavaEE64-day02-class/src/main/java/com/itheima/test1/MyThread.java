package com.itheima.test1;

public class MyThread implements Runnable {


    @Override
    public void run() {
        method();
    }

    private synchronized void method() {
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
    }
}
