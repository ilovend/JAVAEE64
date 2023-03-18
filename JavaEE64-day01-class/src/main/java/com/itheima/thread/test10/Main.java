package com.itheima.thread.test10;

public class Main {
    public static void main(String[] args) {
        /*
         *死锁:
         *1.资源(锁)有限
         *2.同步嵌套
         *
         *<b>
         *面试官:说说什么是死锁,我就雇佣你
         *我:你雇佣我我就告诉你什么是死锁.
         *</b>
         */

        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(()->{
            synchronized (o1) {
                System.out.println("线程一的任务1");
                synchronized (o2) {
                    System.out.println("线程一的任务2");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (o2) {
                System.out.println("线程二的任务1");
                synchronized (o1) {
                    System.out.println("线程二的任务2");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
