package com.geekbrains.java.lesson7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(0);
        Cat cat[] = new Cat[4];
        cat[0] = new Cat("Вася", 25);
        cat[1] = new Cat("Игорь", 15);
        cat[2] = new Cat("Кири", 10);
        cat[3] = new Cat("Веня", 5);
        while(true) {
            if (plate.getFoodPlate() >= 0) {
                for (int i = 0; i < cat.length; i++) {
                    if (plate.eatingFood(cat[i].getAmountOfFood())) {
                        cat[i].setAmountOfFood(0);
                        System.out.printf("Кот %s насытился.", cat[i].getName());
                        System.out.println();
                    } else {
                        System.out.printf("Еды не достаточно для кота %s", cat[i].getName());
                        System.out.println();
                    }
                }
                for (int i = 0; i < cat.length; i++) {
                    if (plate.getFoodPlate() == 0 || plate.getFoodPlate() < cat[i].getAmountOfFood()) {
                        System.out.println("Тарелка пуста");
                        plate.addFood(plate.getFoodPlate());
                    }
                }
                if (allCatsAreFed(cat)) return;
            }
        }
    }
    public static boolean allCatsAreFed(Cat cat[]) {
        boolean allCats = true;
        for (int i = 0; i < cat.length; i++) {
            allCats &= (cat[i].getAmountOfFood() == 0);
        }
        if (allCats) {
            System.out.println("Все коты накормлены!");
            return true;
        }
        return false;
    }
}
