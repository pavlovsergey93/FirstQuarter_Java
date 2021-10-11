package com.geekbrains.java.lesson6;

public class Cats extends Animals{
    private static int countCat = 0;
    Cats(){
        setANIMALS(1);
        setCountCat(1);
    }
    Cats(String name, String species, String color, double age){
        setName(name);
        setSpecies(species);
        setColor(color);
        setAge(age);
        setANIMALS(1);
        setCountCat(1);
    }

    public static int getCountCat() {
        return countCat;
    }

    public static void setCountCat(int countCat) {
        Cats.countCat += countCat;
    }

    @Override
    public void runAnimal (int run){
        if (run <= 200 && run >= 0)
            System.out.println("Кот " + getName() + " пробежал " + run + " м.");
        else if (run < 0)
            System.out.println("Не доступное значение");
        else
            System.out.println("Кот " + getName() + " устал и не пробежал " + run + " м.");
    }
    @Override
    public void swimAnimal(int swim){
        System.out.println("Кот " + getName() + " не умеют плавать");
    }
}
