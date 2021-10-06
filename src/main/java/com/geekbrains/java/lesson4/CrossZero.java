package com.geekbrains.java.lesson4;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class CrossZero {
    public static char map[][], mapCheck[][];
    public static int DOTS_TO_WIN;
    public static int SIZE;
    public static char DOT_X = 'X';
    public static char DOT_O = 'O';
    public static char DOT_PLAER;
    public static char DOT_PC;
    public static char DOT_EMPTY = '•';
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Минимальный размер поля 3*3.");
        System.out.println("Если поле больше 3*3, для победы необходимо поставить 4-е символа в ряд");
        System.out.println();
        while (true) {
            System.out.print("Введите размер игрового поля: ");
            int checkSize = scanner.nextInt();
            if (checkSize > 2) {
                SIZE = checkSize;
                if (SIZE == 3) DOTS_TO_WIN = 3;
                if (SIZE > 3) DOTS_TO_WIN = 4;
                break;
            }
            else System.out.println("Cделайте другой выбор");
        }
        while(true) {
            System.out.println("Выберите символ для вашего хода: 1 - X, 2 - O");
            int choice = scanner.nextInt();
            if (choice == 1){
                DOT_PLAER = DOT_X;
                DOT_PC = DOT_O;
                break;
            }
            if (choice == 2){
                DOT_PLAER = DOT_O;
                DOT_PC = DOT_X;
                break;
            }
            else {
                System.out.println("Введены некоректные данные");
            }
        }
        initMap();
        printMap();
        while (true){
            if(DOT_PLAER == DOT_X) {
                plaerMove();
                printMap();
                if (checkWin5_5()) {
                    System.out.println("ПОДЕБИЛ Игрок!");
                    scanner.close();
                    break;
                }
                isMapFull();
                if (isMapFull()) {
                    System.out.println("ПОБЕДИЛА ДРУЖДА!");
                    scanner.close();
                    break;
                }
                pcMove();
                printMap();
                isMapFull();
                if (isMapFull()) {
                    System.out.println("ПОБЕДИЛА ДРУЖДА!");
                    scanner.close();
                    break;
                }
                if (checkWin5_5()) {
                    System.out.println("ПОБЕДИЛ ИИ!");
                    scanner.close();
                    break;
                }
            }
            else{
                pcMove();
                printMap();
                isMapFull();
                if (isMapFull()) {
                    System.out.println("ПОБЕДИЛА ДРУЖДА!");
                    scanner.close();
                    break;
                }
                if (checkWin5_5()) {
                    System.out.println("ПОБЕДИЛ ИИ!");
                    scanner.close();
                    break;
                }
                plaerMove();
                printMap();
                if (checkWin5_5()) {
                    System.out.println("ПОДЕБИЛ Игрок!");
                    scanner.close();
                    break;
                }
                isMapFull();
                if (isMapFull()) {
                    System.out.println("ПОБЕДИЛА ДРУЖДА!");
                    scanner.close();
                    break;
                }
            }
        }
        System.out.println("ИГРА ОКОНЧЕНА");
    }
    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void plaerMove(){
        System.out.println("Ход Игрока");
        int v, g;
        System.out.println("Введите координаты хода Х и У");
        while(true) {
            System.out.print("X: ");
            v = scanner.nextInt();
            System.out.print("Y: ");
            g = scanner.nextInt();
            if(v > 0 && v <= SIZE && g > 0 && g <= SIZE){
                if (map[g - 1][v - 1] == DOT_EMPTY) {
                    map[g - 1][v - 1] = DOT_PLAER;
                    return;
                }
            }
            else {
                System.out.println("Зделайте другой выбор");
            }
        }
    }
    public static void pcMove(){
        System.out.print("Ход ИИ: ");
        int v,g;
        while (true){
            v = (int) (Math.random()*10);
            g = (int) (Math.random()*10);
            if (v > 0 && v <= SIZE && g > 0 && g <= SIZE) {
                if (map[g-1][v-1] == DOT_EMPTY){
                    map[g-1][v-1] = DOT_PC;
                    System.out.printf("X: %s  Y: %s", v, g);
                    System.out.println("");
                    return;
                }
            }
        }
    }
    public static boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }
//    public static boolean checkWin(char symb){
//        // горизонтайль и вертикаль
//        for (int i = 0; i < SIZE; i++) {
//            boolean horizontal = true, vertical = true;
//            for (int j = 0; j < SIZE; j++) {
//                horizontal = horizontal & (map[i][j] == symb);
//                vertical = vertical & (map[j][i] == symb);
//            }
//            if (horizontal || vertical) return true;
//        }
//        // диагонали
//        boolean rightDiag = true, leftDiag = true;
//        for (int i = 0; i < SIZE; i++) {
//            rightDiag = rightDiag & (map[i][i] == symb);
//            leftDiag = leftDiag & (map[i][SIZE-1 - i] == symb);
//        }
//        if(rightDiag || leftDiag) return true;
//        return false;
//    }
    public static boolean checkWin2(char symb){
        // горизонтайль и вертикаль
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            boolean horizontal = true, vertical = true;
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                horizontal = horizontal & (mapCheck[i][j] == symb);
                vertical = vertical & (mapCheck[j][i] == symb);
            }
            if (horizontal || vertical) return true;
        }
        // диагонали
        boolean rightDiag = true, leftDiag = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            rightDiag = rightDiag & (mapCheck[i][i] == symb);
            leftDiag = leftDiag & (mapCheck[i][DOTS_TO_WIN-1 - i] == symb);
        }
        if(rightDiag || leftDiag) return true;
        return false;
    }
    public static boolean checkWin5_5(){
        mapCheck = new char[DOTS_TO_WIN][DOTS_TO_WIN];
        for (int g = 0; g <=  SIZE - DOTS_TO_WIN; g++) {
            for (int v = 0; v <= SIZE - DOTS_TO_WIN; v++) {
//                System.out.println("__________");
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    for (int j = 0; j < DOTS_TO_WIN; j++) {
                        mapCheck[i][j] = map[i+g][j+v];
//                        System.out.print(mapCheck[i][j] + " ");
                    }
//                    System.out.print("|");
//                    System.out.println();
                }
                if(checkWin2(DOT_PLAER) || checkWin2(DOT_PC)) return true;
            }
        }
        return false;
    }
    // Блокировка хода PLAER (не готова)
    public static void pcCheckWin(){
        for (int g = 0; g <=  SIZE - DOTS_TO_WIN; g++) {
            for (int v = 0; v <= SIZE - DOTS_TO_WIN; v++) {
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    for (int j = 0; j < DOTS_TO_WIN; j++) {
                        mapCheck[i][j] = map[i + g][j + v];
                        if(mapCheck[i][j] == DOT_EMPTY)
                            mapCheck[i][j] = DOT_PLAER;
                    }
                }
                if (checkWin3(DOT_PLAER)) {

                }
            }
        }
    }
    public static boolean checkWin3(char symb){
        // горизонтайль и вертикаль
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            boolean horizontal = true, vertical = true;
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                horizontal = horizontal & (mapCheck[i][j] == symb);
                vertical = vertical & (mapCheck[j][i] == symb);
            }
            if (horizontal || vertical) return true;
        }
        // диагонали
        boolean rightDiag = true, leftDiag = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            rightDiag = rightDiag & (mapCheck[i][i] == symb);
            leftDiag = leftDiag & (mapCheck[i][DOTS_TO_WIN-1 - i] == symb);
        }
        if(rightDiag || leftDiag) return true;
        return false;
    }
}
