package com.itheima.thread.test1;

public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("坦克");
        myThread2.setName("飞机");

        myThread1.start();
        myThread2.start();
    }
}
