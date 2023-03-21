package com.itheima.test3;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Animal> aClass1 = Animal.class;
        Animal animal = new Animal();
        Class<? extends Animal> aClass2 = animal.getClass();
        Class<?> aClass3 = Class.forName("com.itheima.test3.Animal");
        System.out.println(aClass1);
        System.out.println(aClass2);
        System.out.println(aClass3);

        /*
        * 字节码对象是在类的加载过程中创建的,上面三种仅仅是获取字节码对象而已,获取到的其实是同一个字节码对象
        * */
        System.out.println(aClass1 == aClass2);
        System.out.println(aClass2 == aClass3);
        System.out.println(aClass1 == aClass3);
        /*
        *
        * 什么是字节码对象?Class类的对象
        * Student类是描述学生的类
        *   学生的特征
        *   姓名
        *   年龄
        *   生日
        * 例如:class Student{
        * }
        * Animal是描述动物的类
        *   动物的特征
        *       吃饭
        *       年龄
        *       颜色
        *
        * 例如:class Animal{
        * }
        * Class类是描述什么的类?
        * Class类是描述类的类
        *   类的特征
        *       属性
        *       方法
        *       构造
        *       代码块
        * class Class{
        *       String className;
        *       属性[] arr;
        *       方法[] methods;
        *       构造[] con;
        * }
        * class Filed{
        *   String name;//属性名
        *   String value;
        *   String type;
        * }
        *
        * class Method{
        *       String methodName;
        *       String resultType;
        *       String body;
        *       String[] params;
        * }
        *
        *
        *
        * */

    }
}
