package com.itheima.homework.full;

import java.util.Queue;

/**
 * 疫苗接种任务
 */
public class VaccinationTask implements Runnable {
    /**
     * 窗口
     */
    private final Window window;
    /**
     * 队列
     */
    private final Queue<String> queue;

    /**
     * 疫苗接种任务
     *
     * @param queue  队列
     * @param window 窗口
     */
    public VaccinationTask(Queue<String> queue, Window window) {
        this.queue = queue;
        this.window = window;
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        while (true) {
            String name;
            synchronized (queue) {
                if (queue.isEmpty()) {
                    break;
                }
                name = queue.poll();
            }
            window.takeVaccine(name);
        }
    }
}
