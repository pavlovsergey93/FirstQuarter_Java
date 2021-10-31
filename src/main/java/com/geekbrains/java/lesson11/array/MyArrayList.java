package com.geekbrains.java.lesson11.array;

import com.geekbrains.java.lesson11.array.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<T> {
    public <E> void rebase(int index1, int index2, E[] array){
        if (index1 < array.length && index2 < array.length){
            E temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
            return;
        }
        System.out.println("Такого элемента не существует");

    }
    public ArrayList<T>  ArrayToArrayList(T[] array){
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(List.of(array));
        return (ArrayList<T>) arrayList;
    }

}