package com.geekbrains.java.lesson6;

import java.security.interfaces.DSAKeyPairGenerator;

public class Main {
    public static void main(String[] args) {
        Animals animals[] = new Animals[100];
        animals[0] = new Cats("Майка","Шиншила", "Триколор", 7);
        animals[1] = new Cats();
        animals[2] = new Dogs();
        animals[3] = new Dogs();
        animals[4] = new Cats();
        animals[5] = new Dogs();
        System.out.println("Всего животных: ");
        animals[0].runAnimal(201);

    }
}
