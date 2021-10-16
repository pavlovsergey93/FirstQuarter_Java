package com.geekbrains.java.lesson7;

public class Cat {
    private String name;
    private int amountOfFood;

    Cat(String name, int amountOfFood){
        setName(name);
        setAmountOfFood(amountOfFood);
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
