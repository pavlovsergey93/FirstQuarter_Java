package com.geekbrains.java.lesson6;

public class Dogs extends Animals{
    Dogs(){
        setANIMALS(+1);
    }

    Dogs(String name, String species, String color, double age){
        setName(name);
        setSpecies(species);
        setColor(color);
        setAge(age);
        setANIMALS(+1);
    }
    @Override
    public void runAnimal(int run){
        if (run <= 500 && run >= 0)
            System.out.println("Собака " + getName() + " пробежала " + run + " м.");
        else
            System.out.println("Собака " + getName() + " устала и не пробежал " + run + " м.");
    }
    @Override
    public void swimAnimal(int swim){
        if (swim <= 10 && swim >= 0)
            System.out.println("Собака " + getName() + " проплыла " + swim + " м.");
        else
            System.out.println("Собака " + getName() + " не проплывет" + swim + " м.");

    }
}
