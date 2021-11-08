package com.geekbrains.java.lesson11.task;

import com.geekbrains.java.lesson11.task.box.Box;
import com.geekbrains.java.lesson11.task.fruit.Apple;
import com.geekbrains.java.lesson11.task.fruit.Fruit;
import com.geekbrains.java.lesson11.task.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        float wtApple = 1.0f;
        float wtOrange = 1.5f;
        Apple apple1 = new Apple(wtApple, 10);
        Apple apple2 = new Apple(wtApple, 25);
        Orange orange1 = new Orange(wtOrange,15);
        Orange orange2 = new Orange(wtOrange, 30);

        Box<Apple> appleBox1 = new Box<>(apple1);
        Box<Apple> appleBox2 = new Box<>(apple2);
        Box<Orange> orangeBox1 = new Box<>(orange1);
        Box<Orange> orangeBox2 = new Box<>(orange2);

        appleBox1.transferToAnotherBox(orangeBox1);

        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

        //appleBox1.transferToAnotherBox();

        //Box newBox = appleBox2.transferToAnotherBox();
        //System.out.println(newBox.getWeight());
        System.out.println(appleBox2.getWeight());


    }
}
