package com.geekbrains.java.lesson9;

import com.geekbrains.java.lesson9.Exception.MyArrayDataException;
import com.geekbrains.java.lesson9.Exception.MyArraySizaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // При создании публичного сканера пропускает запись первого элемента массива
    // public static Scanner scanner = new Scanner(System.in);
    public static int SIZE;
    public static String ARRAY[][] /*= {
          //  0   1   2   3
            {"1","1","1","1"},   // 0
            {"1","1","str","1"}, // 1
            {"1","1","1","1"},   // 2
            {"1","1","1","1"}    // 3
    }*/;
    public static void main(String[] args) {
        try {
            SIZE = arrayMass();
            if (SIZE != 4) {
                throw new MyArraySizaException("Размер массива должен быть равен 4-м");
            }
        } catch (NullPointerException | InputMismatchException exception) {
            System.out.println(exception.getMessage());
        }
        arrayAdd(SIZE); // или разкоментировать ARRAY[][]
        System.out.println("Сумма элементов массива равна: " + arrayInit(SIZE, ARRAY));

    }
    // Метод переопределения содержимого ячеек массива из String в int и подсчет суммы ячеек массива
    private static int arrayInit(int size, String array[][]) {
        int sumArray = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    sumArray += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException exception){
                    throw new MyArrayDataException("Ячкейка [" + i +"][" + j +"] содержит строку");
                }
            }
        }
        return sumArray;
    }
    // Метод ввода размерности массива
    public static int arrayMass(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива 4");
        int size = scanner.nextInt();
        return size;
    }
    // Метод ввода данных в ячейки массив
    public static void arrayAdd(int size){
        System.out.println("Заполните массив значениями:");
        ARRAY = new String[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("[%s][%s]: ",i,j);
                ARRAY[i][j] = scanner.nextLine();
            }
            System.out.println();
        }
    }
}
