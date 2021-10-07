package com.geekbrains.java.lesson5;

import javax.print.DocFlavor;

public class Worker {
    private String surname, name, patronymic;
    private String post;
    private String email;
    private int phoneNumber;
    private int wage;
    private int age;

    public Worker() {   }
    public Worker(String surname, String name, String patronymic, String post, String email,
                                     int phoneNumber, int wage, int age){
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setPost(post);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setWage(wage);
        setAge(age);
    }
    public void printInfoWorker(){
        System.out.printf("ФИО: %s %s %s \nДолжность: %s \nВозраст: %s \nE-mail: %s \nТелефон: %s \nЗаработная плата: %s\n", surname, name, patronymic, post, age, email, phoneNumber, wage);
        System.out.println("------------------------------");
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public String getPatronymic(){
        return this.patronymic;
    }
    public void setPost(String post){
        this.post = post;
    }
    public String getPost(){
        return this.post;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setWage(int wage){
        this.wage = wage;
    }
    public int getWage(){
        return this.wage;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
}
