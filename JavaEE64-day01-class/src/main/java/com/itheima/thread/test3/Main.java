package com.itheima.thread.test3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        method1();
//        method2();//错误写法
        method3();//正确写法

    }

    private static void method3() throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask1 = new FutureTask<String>(myCallable);
        FutureTask<String> futureTask2 = new FutureTask<String>(myCallable);

        Thread thread1 = new Thread(futureTask1, "飞机");
        Thread thread2 = new Thread(futureTask2, "坦克");

        thread1.start();
        thread2.start();

        String s1 = futureTask1.get();
        String s2 = futureTask2.get();
        System.out.println("线程1" + s1);
        System.out.println("线程2" + s2);
    }

    private static void method2() {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
        Thread thread1 = new Thread(futureTask, "飞机");
        Thread thread2 = new Thread(futureTask, "坦克");

        thread1.start();
        thread2.start();
        /*
        返回结果只会执行飞机,而坦克根本没执行
        !!!!!所以这个是中错误写法!!!!!!!
         */
    }

    private static void method1() throws InterruptedException, ExecutionException {
        //        任务创建
        MyCallable myCallable = new MyCallable();
//        FutureTask其实就是runnable任务类(线程指定的任务类)
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
//        创建一个线程
        Thread thread1 = new Thread(futureTask);
        thread1.start();
//        获取线程执行结果
        String s = futureTask.get();
        System.out.println(s);
    }
}
