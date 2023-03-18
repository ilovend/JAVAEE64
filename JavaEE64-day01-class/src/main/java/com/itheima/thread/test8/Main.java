package com.itheima.thread.test8;

public class Main {
    public static void main(String[] args) {
        //        创建任务类对象
       SellTicket sellTicket = new SellTicket();
//        创建三个线程对象
        Thread t1 = new Thread(sellTicket, "窗口一");
        Thread t2 = new Thread(sellTicket, "窗口二");
        Thread t3 = new Thread(sellTicket, "窗口三");

//        启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}
