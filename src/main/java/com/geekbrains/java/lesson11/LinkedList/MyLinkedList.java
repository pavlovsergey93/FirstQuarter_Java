package com.geekbrains.java.lesson11.LinkedList;

import java.util.ArrayList;

public class MyLinkedList<T> {
    private class Node{
        T data;
        Node next; // ссылка на след.элемент
        Node prev; // ссылка на пред.элемент

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;
    private Node temp = null;
    private Node tail = null;

    public void addNode(T data){
        Node newNode = new Node(data);
        temp = head;

        if(head == null){ // когда лист пуст
            head = newNode; // поставить первым значение
        }
        else{
            while(temp.next != null){
                temp = temp.next;
            }
            tail.next = newNode; // добавить ссылку на следующий элемент
            tail.prev = temp; // добавить ссылку на предыдущий элемент
        }
        tail = newNode;

    }

    public void display(){
        Node current = head;

        if(current == null){
            System.out.println("Лист пустой");
            return;
        }
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void display(int index){
        Node current = head;
        if (current == null){
            System.out.println("Лист пуст!");
        }
        try {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }catch (NullPointerException e){
            System.out.println("Индекс выходит за пределы листа");
            return;
        }
        System.out.println(current.data);
    }

}
