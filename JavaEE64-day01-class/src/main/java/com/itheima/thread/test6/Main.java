package com.itheima.thread.test6;


public class Main {
    /**
     *
     * setPriority设置优先级
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
//        创建两个线程
        Thread myThread1 = new MyThread();
        Thread myThread2 = new MyThread();
//        设置名称
        myThread1.setName("飞机");
        myThread2.setName("坦克");
//        设置优先级
        myThread1.setPriority(10);
        myThread2.setPriority(1);

        int priority1 = myThread1.getPriority();
        int priority2 = myThread2.getPriority();
        System.out.println(priority1);
        System.out.println(priority2);
//        启动线程
        myThread1.start();
        myThread2.start();

    }
}
