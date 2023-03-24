package com.itheima.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    @After
    public void after() {
        System.out.println("after会在每个测试之前执行");
    }

    @Before
    public void before() {
        System.out.println("before会在每个测试之后执行");
    }

    @Test
    public void testMethod1() {
        System.out.println("testMethod1");
    }
}
