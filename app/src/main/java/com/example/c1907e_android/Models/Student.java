package com.example.c1907e_android.Models;

import java.util.Date;

public class Student {
    private String name;
    private String learningClass;
    private Date birthday;

    public Student(String name, String learningClass, Date birthday) {
        this.name = name;
        this.learningClass = learningClass;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLearningClass() {
        return learningClass;
    }

    public void setLearningClass(String learningClass) {
        this.learningClass = learningClass;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
