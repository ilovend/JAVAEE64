package com.itheima.thread.test5;

/*
 * 线程的休眠: 哪个线程执行到Thread.sleep
 * */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        method1();
//        method2();

    }

    private static void method2() throws InterruptedException {
        System.out.println(1);
        Thread.sleep(2000);
        System.out.println(2);
    }

    private static void method1() {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.setName("飞机");
        myThread2.setName("坦克");
        System.out.println("main:" + myThread1.getName());
        System.out.println("main:" + myThread2.getName());
        myThread1.start();
        myThread2.start();
    }
}
