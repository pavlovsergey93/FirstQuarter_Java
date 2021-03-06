package com.geekbrains.java.lesson11.task.box;

import com.geekbrains.java.lesson11.task.fruit.Fruit;

public class Box<T extends Fruit> {
    private T[] fruitBox;

    public Box(T... fruit) {
        this.fruitBox = fruit;
    }

    public float getWeight(){
        float weight = 0f;
        for(int i = 0; i < fruitBox.length; i++){
            weight += (fruitBox[i].getWt() * (float) fruitBox[i].getCount());
        }
        return weight;
    }

    public boolean compare(Box<?> newBox){
        if (this.getWeight() == newBox.getWeight()) {
            System.out.println("Коробки равны");
            return true;
        }
        System.out.println("Коробки не равны");
        return false;
    }
    public void transferToAnotherBox(Box<?> box) {
        if (this.fruitBox.getClass().equals(box.getClass())) {
            for (int i = 0; i < fruitBox.length; i++) {
            //     box.setCount += fruitBox[i].getCount();
                fruitBox[i].setCount(0);
            }
        }else{
            System.out.println("Нет возможности пересыпать фрукты в эту коробку");
        }
    }

    public T[] getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(T[] fruitBox) {
        this.fruitBox = fruitBox;
    }
}
