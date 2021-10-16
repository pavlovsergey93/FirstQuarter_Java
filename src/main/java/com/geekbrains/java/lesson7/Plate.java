package com.geekbrains.java.lesson7;

import java.io.IOException;
import java.util.Scanner;

public class Plate {
    private int foodPlate;

    Plate(int foodPlate){
        if(foodPlate >=0) {
            setFoodPlate(foodPlate);
        }
        else {
            System.out.println("Тарелка не может содержать отрицательное значение");
        }
    }

    public int getFoodPlate() {
        return foodPlate;
    }
    public void setFoodPlate(int foodPlate) {
        this.foodPlate = foodPlate;
    }
    public boolean eatingFood(int catEat){
        if(foodPlate >= catEat){
            foodPlate -= catEat;
            setFoodPlate(foodPlate);
            return true;
        }
        else return false;
    }
    public void addFood(int plateFood){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Покормите оставшихся котов. \nСколько еды добавить в тарелку?");
        int add = scanner.nextInt();
        setFoodPlate(add + plateFood);
    }
}
