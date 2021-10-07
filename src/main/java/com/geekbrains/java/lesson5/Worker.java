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
    public Worker(String _surname, String _name, String _patronymic, String _post, String _email,
                                     int _phoneNumber, int _wage, int _age){
        this.surname = _surname;
        this.name = _name;
        this.patronymic = _patronymic;
        this.post = _post;
        this.wage = _wage;
        this.age = _age;
        this.phoneNumber = _phoneNumber;
        this.email = _email;

    }
    public void printInfoWorker(){
        System.out.printf("ФИО: %s %s %s \nДолжность: %s \nВозраст: %s \nE-mail: %s \nТелефон: %s \nЗаработная плата: %s\n", surname, name, patronymic, post, age, email, phoneNumber, wage);
        System.out.println("------------------------------");
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public void setPost(String post){
        this.post = post;
    }
    public String getPost(){
        return post;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setWage(int wage){
        this.wage = wage;
    }
    public int getWage(){
        return wage;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
