package com.geekbrains.java.lesson9;

import com.geekbrains.java.lesson9.Exception.MyArrayDataException;
import com.geekbrains.java.lesson9.Exception.MyArraySizaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // При создании публичного сканера пропускает запись первого элемента массива
    // public static Scanner scanner = new Scanner(System.in);
    public static int SIZE;
    public static void main(String[] args) {
        try {
            SIZE = arrayMass();
            if (SIZE != 4) {
                throw new MyArraySizaException("Размер массива должен быть равен 4-м");
            }
        } catch (NullPointerException | InputMismatchException exception) {
            System.out.println(exception.getMessage());
        }
        String array[][] = new String[SIZE][SIZE];
        System.out.println("Заполните массив значениями:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("[%s][%s]: ",i,j);
                array[i][j] = scanner.nextLine();
            }
        }


    }
    public static int arrayMass(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива 4");
        int size = scanner.nextInt();
        return size;
    }
}
