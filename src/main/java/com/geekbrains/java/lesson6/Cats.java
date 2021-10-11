package com.geekbrains.java.lesson6;

public class Cats extends Animals{
    Cats(){
        setANIMALS(+1);
    }
    Cats(String name, String species, String color, double age){
        setName(name);
        setSpecies(species);
        setColor(color);
        setAge(age);
        setANIMALS(+1);
    }
    @Override
    public void runAnimal (int run){
        if (run <= 200 && run >= 0)
            System.out.println("Кот " + getName() + " пробежал " + run + " м.");
        else
            System.out.println("Кот " + getName() + " устал и не пробежал " + run + " м.");
    }
    @Override
    public void swimAnimal(int swim){
        System.out.println("Кот" + "не умеют плавать");
    }
}
