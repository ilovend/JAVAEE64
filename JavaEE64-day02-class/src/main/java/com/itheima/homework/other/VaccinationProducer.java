package com.itheima.homework.other;

import java.util.concurrent.BlockingQueue;

/**
 * 疫苗生产者
 */
public class VaccinationProducer implements Runnable {
    private final BlockingQueue<String> taskQueue;
    private final Window window;

    /**
     * 构造方法
     *
     * @param taskQueue 任务队列
     * @param window    窗口
     */
    public VaccinationProducer(BlockingQueue<String> taskQueue, Window window) {
        this.taskQueue = taskQueue;
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 从任务队列中获取任务（即名字）
                String name = taskQueue.take();

                // 将任务放入窗口中
                window.takeVaccine(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
