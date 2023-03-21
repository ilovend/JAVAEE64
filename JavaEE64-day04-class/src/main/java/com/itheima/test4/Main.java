package com.itheima.test4;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
// 获取指定public单个无参构造方法：
        Class<Bird> birdClass = Bird.class;
        Constructor<Bird> constructor1 = birdClass.getConstructor();
        System.out.println("指定public单个无参构造方法：" + constructor1);

        // 获取所有public构造方法：
        Constructor<?>[] constructor2 = birdClass.getConstructors();
        System.out.println("所有public构造方法：");
        for (Constructor<?> constructor : constructor2) {
            System.out.println(constructor);
        }

        // 获取指定public单个有参构造方法：
        Constructor<Bird> constructor3 = birdClass.getConstructor(String.class, String.class);
        System.out.println("指定public单个有参构造方法：" + constructor3);

        // 获取所有构造方法（包括private）：
        Constructor<?>[] allConstructors = birdClass.getDeclaredConstructors();
        System.out.println("所有构造方法（包括private）：");
        for (Constructor<?> constructor : allConstructors) {
            System.out.println(constructor);
        }

        // 获取指定private构造方法：
        Constructor<Bird> privateConstructor = birdClass.getDeclaredConstructor(String.class,String.class);
        System.out.println("指定private构造方法：" + privateConstructor);
        // 使用private构造方法创建对象
        privateConstructor.setAccessible(true);
        Bird bird = privateConstructor.newInstance("Private Bird", "10");
        System.out.println("使用private构造方法创建的对象：" + bird);
    }
}
