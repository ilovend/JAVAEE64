package com.itheima.thread.test3;

import java.util.concurrent.Callable;

/**
 * 获取线程执行结果futureTask.get(): 是阻塞的,线程没有执行完,这个代码会停在等线程执行玩
 *
 * @author ilovend
 * @date 2023/03/17
 */
public class MyCallable implements Callable {

    /**
     * 调用
     * call方法:相当于之前的run方法,多了个返回值
     *
     * @return {@link Object}
     * @throws Exception 异常
     */
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +":"+ "给女孩子表白");
        }
        return "答应";
    }
}
