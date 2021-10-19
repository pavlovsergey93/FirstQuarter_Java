package com.geekbrains.java.lesson8;

import com.geekbrains.java.lesson8.person.Customer;
import com.geekbrains.java.lesson8.person.Salesman;
import com.geekbrains.java.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Market market = new Market();

        System.out.println("Вы 1-Продавец 2-Покупатель");
        int sc = scanner.nextInt();
        if(sc == 1) {
            List<Salesman> salesmanList = new ArrayList<>();
            while(true) {
                System.out.println("Введите Имя:");
                String name = scanner.nextLine();
                System.out.println("Введите фамилию: ");
                String secondName = scanner.nextLine();
                salesmanList.add(createFirstSalseman(name, secondName, 0));
                market.setSalesmanList(salesmanList);
                System.out.println("Добавить продовца? y/n");
                String result = scanner.nextLine();
                if(result == "n") return;
            }
        }
        else if (sc == 2) {
            Customer customer = createCustemer();
            customer.findProductOnMarket(market);
            customer.whatIBoughtIngo();
        }
    }
    private static Salesman createFirstSalseman(String name, String secondName, int cash) {
        List<Product> productList = new ArrayList<>();
        while (true) {
            System.out.println("Наименование продукта: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Цена продукта: ");
            int priceProduct = scanner.nextInt();
            System.out.println("Количество продукта:");
            int countProduct = scanner.nextInt();
            Product firstProduct = new Product(nameProduct, priceProduct, countProduct);
            productList.add(firstProduct);
        }
        Salesman salesman = new Salesman(name, secondName, cash, productList);
        return salesman;
    }
    private static Customer createCustemer(){
        Product firstProduct = new Product("Помидоры", 3);
        Product secondProduct = new Product("Огурцы", 5);
        return new Customer(List.of(firstProduct, secondProduct),80);
    }

}
