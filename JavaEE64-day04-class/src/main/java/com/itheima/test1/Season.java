package com.itheima.test1;

/*
*
* 1.枚举类的使用
* 1.1 JDK5.0新增的特性
* 1.2 如何定义枚举类
* 1.3 如何使用枚举类
* 1.4 枚举类的实现原理
*
*
* */
enum Season {
//    定义枚举类的实例
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "白雪皑皑");
//    定义枚举类的属性
    private String name;
    private String desc;
//    定义枚举类的构造方法
    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
//    定义枚举类的方法
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
