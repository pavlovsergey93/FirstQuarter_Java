package com.geekbrains.java.lesson11.array;

public class MainArray {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5};
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.rebase(1, 3, array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println(myList.ArrayToArrayList(array));
    }


}
