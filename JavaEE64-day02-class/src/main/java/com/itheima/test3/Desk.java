package com.itheima.test3;


/**
 * 桌子上放生产好的包子
 * false:桌子上没有包子
 *  1.默认桌子没有包子,flag初始值为false
 *  2.被消费者线程迟到包子之后,桌子上也没有包子
 * true:桌子上有包子
 *  1.生产者生产包子之后,桌子上就有包子了
 *
 * @author ilovend
 * @date 2023/03/18
 */
public class Desk {
    public static boolean flag = false;
}
