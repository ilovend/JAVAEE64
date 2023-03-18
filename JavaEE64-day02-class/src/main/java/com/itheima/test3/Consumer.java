package com.itheima.test3;

/**
 * 消费者线程:当桌子上有包子的时候吃包子,没有包子的时候等待唤醒
 *
 * @author ilovend
 * @date 2023/03/18
 */
public class Consumer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if (Desk.flag == true) {
                    System.out.println("消费者吃包子");
                    Desk.flag = false;
                    Desk.class.notify();
                } else {
                    System.out.println("消费者抢到了cpu执行权,但是没有包子,等待");
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
