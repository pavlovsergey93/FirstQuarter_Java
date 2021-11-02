package com.geekbrains.java.lesson12;

import java.util.concurrent.CountDownLatch;

public class Synchronization {

    public synchronized long method1(float array[]){
        long a1 = System.currentTimeMillis();
        initArray(array);
        calculator(array);
        long a2 = System.currentTimeMillis();
        return (a2-a1);
    }
    public synchronized long method2(float array[], int half, int size){
        long a1 = System.currentTimeMillis();
        initArray(array);
        float arr12[] = new float[half];
        float arr22[] = new float[half];
        System.arraycopy(array, 0, arr12, 0, half);
        System.arraycopy(array, half, arr22, 0, half);

        CountDownLatch cdl = new CountDownLatch(2);

        new Thread(()->{
            calculator(arr12);
            cdl.countDown();
        }).start();
        new Thread(()->{
            calculator(arr22);
            cdl.countDown();
        }).start();
        try {
            cdl.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arr12, 0 , array, 0, half);
        System.arraycopy(arr22, 0, array, 0, half);

        long a2 = System.currentTimeMillis();
        return (a2-a1);
    }
    public void calculator(float array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
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
