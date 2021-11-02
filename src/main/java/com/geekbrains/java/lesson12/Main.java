package com.geekbrains.java.lesson12;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;

    public static void main (String[] args) {

        float array[] = new float[SIZE];
        initArray(array);
        Synhronization sync = new Synhronization();
        Synhronization sync1 = new Synhronization();

        new Thread(()-> System.out.println("Выполнение подсчета в один поток: " + sync.method1(array) + " мс")).start();
        new Thread(()-> System.out.println("Выполнение подсчета в два потока: " + sync.method2(array, HALF, SIZE)+ " мс")).start();
        new Thread(()-> System.out.println("Выполнение подсчета в два потока (CountDownLatch): " + sync.method3(array, HALF, SIZE)+ " мс")).start();


    }
    public static void initArray(float array[]) {
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++){
            array[i] = 1f;
        }
        long a2 = System.currentTimeMillis();
        System.out.println("Время заполнение массива: " + (a2-a1) + " мс");
    }
}
