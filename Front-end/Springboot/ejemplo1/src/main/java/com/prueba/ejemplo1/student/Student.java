package com.prueba.ejemplo1.student;


import java.time.LocalDate;


public class Student {
    private Long id;
    private String name;
    private Integer age;
    private LocalDate dov;
    private String email;

    public Student() {
    }

    
    public Student(String name, Integer age, LocalDate dov, String email) {
        this.name = name;
        this.age = age;
        this.dov = dov;
        this.email = email;
    }


    public Student(Long id, String name, Integer age, LocalDate dov, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dov = dov;
        this.email = email;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public LocalDate getDov() {
        return dov;
    }


    public void setDov(LocalDate dov) {
        this.dov = dov;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Student [age=" + age + ", dov=" + dov + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    
}
