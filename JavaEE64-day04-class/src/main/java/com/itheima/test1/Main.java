package com.itheima.test1;

public class Main {


    /*
     * 定义一个Person类,name属性,Gender性别必须枚举
     * 测试类中创建Person对象,打印name属性和性别
     * */

    public static void main(String[] args) {
        Person p1 = new Person(Gender.MALE, "张三");
        Person p2 = new Person(Gender.FEMALE, "李四");

        System.out.println(p1.getName() + " " + p1.getGender().getName());
        System.out.println(p2.getName() + " " + p2.getGender().getName());
    }
}
