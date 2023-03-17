package com.itheima.thread.test2;

public class Main {
    public static void main(String[] args) {
//        创建一个任务对象
        MyRunnable myRunnable = new MyRunnable();
//        创建两个线程对象,并把任务给到两个线程,并给任务起名字
        Thread thread1 = new Thread(myRunnable,"飞机");
        Thread thread2 = new Thread(myRunnable,"坦克");
//        开启两个线程:cpu会执行两个线程中的代码(随机,交替)
        thread1.start();
        thread2.start();

    }
}
