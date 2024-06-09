package com.ttn.demo.core.beans;

import com.adobe.cq.wcm.core.components.internal.DataLayerConfig;
public class Student {
    private String id;
    private String name;
    private int marks;
    private int age;

    public Student(String id, String name, int marks, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
