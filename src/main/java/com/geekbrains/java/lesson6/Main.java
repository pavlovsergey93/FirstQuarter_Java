package com.geekbrains.java.lesson6;

import java.security.interfaces.DSAKeyPairGenerator;

public class Main {
    public static void main(String[] args) {
        Animals animals[] = new Animals[100];
        animals[0] = new Cats("Майка","Шиншила", "Триколор", 7);
        animals[1] = new Cats("Борис", "Перс", "Белый", 3);
        animals[2] = new Dogs("Оскар", "Джек-рассел-терьер", "Бело-коричневый", 0.11);
        animals[3] = new Dogs("Эльма", "Шит-цу", "Бежевая", 1);
        animals[4] = new Cats("Веник", "Британская вислоухая", "Пепельный", 3);
        animals[5] = new Dogs("Тайсон", "Пит-Буль", "Коричневый", 3.7);
        System.out.printf("Всего животных: %s\nКотов: %s\nСобак: %s\n",Animals.getANIMALS(),Cats.getCountCat(), Dogs.getCountDog());
        for (int i = 0; i < Animals.getANIMALS(); i++) {
            animals[i].runAnimal((int) (Math.random()*500));
            animals[i].swimAnimal((int) (Math.random()*50));
        }
    }
}
