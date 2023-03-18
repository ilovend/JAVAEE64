package com.itheima.test3;

/*
等待唤醒
案例:生产这
 */
public class Main {
    public static void main(String[] args) {
        Maker maker = new Maker();
        Consumer consumer = new Consumer();

        maker.start();
        consumer.start();
    }
}
