package com.geekbrains.java.lesson6;

public class Dogs extends Animals{
    private static int countDog = 0;
    Dogs(){
        setANIMALS(1);
        setCountDog(1);
    }

    Dogs(String name, String species, String color, double age){
        setName(name);
        setSpecies(species);
        setColor(color);
        setAge(age);
        setANIMALS(1);
        setCountDog(1);
    }

    public static int getCountDog() {
        return countDog;
    }
    public static void setCountDog(int countDog) {
        Dogs.countDog += countDog;
    }

    @Override
    public void runAnimal(int run){
        if (run <= 500 && run >= 0)
            System.out.println("Собака " + getName() + " пробежала " + run + " м.");
        else if (run < 0)
            System.out.println("Не доступное значение");
        else
            System.out.println("Собака " + getName() + " устала и не пробежал " + run + " м.");
    }
    @Override
    public void swimAnimal(int swim){
        if (swim <= 10 && swim >= 0)
            System.out.println("Собака " + getName() + " проплыла " + swim + " м.");
        else
            System.out.println("Собака " + getName() + " не проплывет " + swim + " м.");

    }
}
