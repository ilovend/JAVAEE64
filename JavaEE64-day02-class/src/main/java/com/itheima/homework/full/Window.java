package com.itheima.homework.full;

/**
 * 窗口
 */
public class Window {
    /**
     * 疫苗接种时间
     */
    private static final int VACCINATION_TIME = 2000;
    /**
     * 名字
     */
    private final String name; // 窗口名称
    /**
     * 现在名字
     */
    private String currentName; // 当前正在接受注射的小朋友的名字

    /**
     * 窗口
     *
     * @param name 名字
     */
    public Window(String name) {
        this.name = name;
    }

    /**
     * 接受疫苗
     *
     * @param name 名字
     */
    public synchronized void takeVaccine(String name) {
        currentName = name;
        System.out.println(name + "小朋友在" + this.name + "接受注射");
        try {
            Thread.sleep(VACCINATION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "小朋友在" + this.name + "接受注射完成");
        currentName = null;
    }

    /**
     * 得到名字
     *
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * 得到当前名字
     *
     * @return {@link String}
     */
    public String getCurrentName() {
        return currentName;
    }
}
