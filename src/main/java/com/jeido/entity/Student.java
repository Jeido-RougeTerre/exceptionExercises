package com.jeido.entity;

import com.jeido.exception.InvalidAgeException;

public class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) throws InvalidAgeException {
        this.name = name;
        if (age < 18 || age > 85) {
            throw new InvalidAgeException(age);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "'" + name + "' " + age + " yo.";
    }
}
