package com.itheima.test4;

import java.util.concurrent.*;

public class Main {
//    多线程的另一种创建方式
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> future = threadPoolExecutor.submit(new Callable<Integer>() {

            Integer sum = 0;

            @Override
            public Integer call() throws Exception {

                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }

        });

        Future<Integer> future1 = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer take = 1;
                for (int i = 1; i <= 10; i++) {
                    take *= i;
                }
                return take;
            }
        });

        Integer integer = future.get();
        Integer integer1 = future1.get();
        System.out.println(integer);
        System.out.println(integer1);
        threadPoolExecutor.shutdown();


    }
}
