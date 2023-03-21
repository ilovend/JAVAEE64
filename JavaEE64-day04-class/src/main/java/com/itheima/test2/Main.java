package com.itheima.test2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("src/main/resources/prop.properties");
        int available = inputStream.available();

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");

        System.out.println(name);
        System.out.println(age);
    }
}
