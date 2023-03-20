package com.itheima.homework.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 疫苗分配类
 */
public class VaccineDistribution {
    public static void main(String[] args) {
        // 创建任务队列
        BlockingQueue<String> taskQueue = new ArrayBlockingQueue<>(10);

        // 创建窗口
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");

        // 创建生产者和消费者线程池
        ExecutorService producerPool = Executors.newFixedThreadPool(1);
        ExecutorService consumerPool = Executors.newFixedThreadPool(2);

        // 启动生产者
        producerPool.execute(new VaccinationProducer(taskQueue, window1));
        producerPool.execute(new VaccinationProducer(taskQueue, window2));

/*        // 启动消费者
        consumerPool.execute(new VaccinationConsumer(taskQueue, window1));
        consumerPool.execute(new VaccinationConsumer(taskQueue, window2));*/


        // 关闭线程池
        producerPool.shutdown();
        consumerPool.shutdown();
    }
}
