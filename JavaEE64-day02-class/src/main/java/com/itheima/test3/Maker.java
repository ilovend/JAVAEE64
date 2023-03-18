package com.itheima.test3;

/**
 * 生产者:
 *  1.桌子上没有包子就生产包子
 *  2.强盗执行权,发现桌子上有包子,等待
 *
 * @author ilovend
 * @date 2023/03/18
 */
public class Maker extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if (Desk.flag == false) {
                    System.out.println("厨师生产包子");
                    Desk.flag = true;
                    Desk.class.notify();
                } else {
                    System.out.println("厨师抢到了cpu执行权,但桌子上有包子,厨师等待");
                    try {
                        Desk.class.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
