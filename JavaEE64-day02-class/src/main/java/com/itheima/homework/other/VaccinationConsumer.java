package com.itheima.homework.other;

import java.util.concurrent.BlockingQueue;

/**
 * 疫苗消费者
 */
public class VaccinationConsumer implements Runnable {
    private final BlockingQueue<String> taskQueue;
    private final Window window;

    /**
     * 构造方法
     *
     * @param taskQueue 任务队列
     * @param window    窗口
     */
    public VaccinationConsumer(BlockingQueue<String> taskQueue, Window window) {
        this.taskQueue = taskQueue;
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从任务队列中获取任务（即名字）
                String name = taskQueue.take();

                // 找一个可用的窗口接种疫苗
                while (true) {
                    if (window.isAvailable()) {
                        window.takeVaccine(name);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
