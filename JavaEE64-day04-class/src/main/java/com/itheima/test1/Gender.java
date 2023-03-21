package com.itheima.test1;

public enum Gender {
    MALE("男"), FEMALE("女");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
