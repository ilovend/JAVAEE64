package com.itheima.thread.test7;


/**
 * 任务类:卖票
 * 三个窗口,共享100张票,而不是33张
 *
 * @author ilovend
 * @date 2023/03/17
 */
public class SellTicket implements Runnable {
    final Object obj = new Object();
    private int tickets = 100;//任务的总票数

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            不管是哪个窗口买票,只要有票就可以卖
                while (true) {
                    synchronized (obj) {
                        //                卖完了就结束
                        if (tickets <= 0) {
                            break;
                        }
                        //                模拟卖票环节
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //                没卖完
                        tickets--;
                        System.out.println(Thread.currentThread().getName() + "正在买票,还剩" + tickets + "张票");
                    }
                }
        }
    }
}
