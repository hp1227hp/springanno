package com.test.entity;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    private String name;

    @Value("#{20-2}")
    private int age;

    public Person() {
        System.out.println("person 无参构造方法...");
    }

    public Person(String name, int age) {
        System.out.println("person 有参构造方法...");
        this.name = name;
        this.age = age;
    }

    public void initPerson() {
        System.out.println("初始化person对象");
    }

    public void destroyPerson() {
        System.out.println("销毁person对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
