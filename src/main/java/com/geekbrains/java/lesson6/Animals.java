package com.geekbrains.java.lesson6;

public abstract class Animals {
    private String name;
    private String species;
    private String color;
    private double age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }
    abstract void runAnimal();
    abstract void swimAnimal();
}
