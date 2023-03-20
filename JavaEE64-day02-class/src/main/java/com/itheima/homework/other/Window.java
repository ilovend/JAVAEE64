package com.itheima.homework.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 疫苗接种窗口
 */
public class Window {
    private final String name;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean available = true;
    private String currentName;

    /**
     * 构造方法
     *
     * @param name 窗口名称
     */
    public Window(String name) {
        this.name = name;
    }

    /**
     * 接种疫苗
     *
     * @param name 名字
     * @throws InterruptedException
     */
    public void takeVaccine(String name) throws InterruptedException {
        lock.lock();
        try {
            while (!available) {
                condition.await();
            }
            currentName = name;
            available = false;
            System.out.println(name + " 在 " + name + " 接种疫苗");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取当前窗口的状态
     *
     * @return 是否空闲
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * 设置窗口的状态
     *
     * @param available 是否空闲
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * 获取当前正在接种疫苗的人名
     *
     * @return 当前正在接种疫苗的人名
     */
    public String getCurrentName() {
        return currentName;
    }

    /**
     * 设置当前正在接种疫苗的人名
     *
     * @param currentName 当前正在接种疫苗的人名
     */
    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /**
     * 获取窗口名称
     *
     * @return 窗口名称
     */
    public String getName() {
        return name;
    }
}
