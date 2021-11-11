package com.geekbrains.java.lesson14;

import org.junit.Assert;
import org.junit.Test;

public class MainL14 {
    public static void main(String[] args) {
        int array[] = new int[10];
        array = initArray(array);
        print(array);
        array = fourToPrint(array);
        print(array);

        int arr[] = new int[]{1,1,1,4,4,1,4,4};
        int arr1[] = new int[]{1,1,1,1,1};
        int arr2[] = new int[]{4,4,4,4};
        int arr3[] = new int[]{1,4,4,1,1,4,3};
        System.out.println(checkOneFour(arr));
        System.out.println(checkOneFour(arr1));
        System.out.println(checkOneFour(arr2));
        System.out.println(checkOneFour(arr3));


    }
    //Заполнение массива
    public static int[] initArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random()*5);
        }
        if (!four(arr)) {
            throw new RuntimeException();
        }
        return arr;
    }
    // Проверка на наличие хотябы одной 4ки в массиве
    public static boolean four(int array[]){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 4){
                return true;
            }
        }
        return false;
    }
    // Вытягиваем в новый массив числа после последней 4
    public static int[] fourToPrint(int array[]){
        int index = checkFour(array);
        int newArray[] = new int[array.length - index];
        int j = 0;
        for (int i = index; i < array.length; i++) {
            newArray[j] = array[i];
            j++;
        }
        return newArray;
    }
    // Поиск последнего элемента, содержавшего 4
    public static int checkFour(int array[]){
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == 4  ){
                return (i + 1);
            }
        }
        return 0;
    }
    // Вывод массива
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //Проверка содержимого массива на наличие только 1 или 4 (хотябы в количестве 1 ед каждого)
    public static boolean checkOneFour(int arr[]){
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4){
                return false;
            }
            if(arr[i] == 1 || arr[i] == 4){
                sumArr += arr[i];
            }
        }
        if(sumArr/arr.length == 1) {
            return false;
        }
        if(sumArr/arr.length == 4) {
            return false;
        }
        return true;
    }

    @Test
    public void testFour(){
        int arr[] = new int[]{1,2,3,4,5,6,5,3};
        Assert.assertTrue(four(arr));
    }

    @Test
    public void testCheckFour(){
        int arr[] = new int[]{1,2,3,0,5,6,5,3};
        Assert.assertEquals(0 , checkFour(arr));
    }
    @Test
    public void testFourToPrint(){
        int arr[] = new int[]{1,2,3,4,5,4,5,3};
        int newArr[] = fourToPrint(arr);
        Assert.assertEquals(5,newArr[0]);
        Assert.assertEquals(3,newArr[1]);
    }

    @Test
    public void testOneFour(){
        int arr[] = new int[]{1,1,1,4,4,1,4,4};
        int arr1[] = new int[]{1,1,1,1,1};
        int arr2[] = new int[]{4,4,4,4};
        int arr3[] = new int[]{1,4,4,1,1,4,3};
        Assert.assertTrue(checkOneFour(arr));
        Assert.assertFalse(checkOneFour(arr1));
        Assert.assertFalse(checkOneFour(arr2));
        Assert.assertFalse(checkOneFour(arr3));
    }

}
