package com.geekbrains.java.lesson11.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainList {
    public static void main(String[] args) {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.addNode(120);
        integerMyLinkedList.addNode(150);
        integerMyLinkedList.addNode(210);
        integerMyLinkedList.addNode(100);

        integerMyLinkedList.display();
        integerMyLinkedList.display(3);


    }
}
