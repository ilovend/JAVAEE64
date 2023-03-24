package com.itheima.day05.test.demo2;


public @interface MyTest {
    String name() default "tom";

    int age() default 0;

    Anno anno() default @Anno;

    Gender gender() default Gender.man;


}
