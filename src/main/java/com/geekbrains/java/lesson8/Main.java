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
        List<Salesman> salesmanList = new ArrayList<>();
        System.out.println("Введите данные продавца");
        do {
            System.out.print("Имя продавца: ");
            String name = scanner.nextLine();
            System.out.print("Фамилия продавца: ");
            String secondName = scanner.nextLine();
            salesmanList.add(createSalseman(name, secondName, 0));
            market.setSalesmanList(salesmanList);
            System.out.println("Добавить продовца? (y/n) ");
            char result = scanner.next().charAt(0);
            scanner.nextLine();
            if(result == 'n') break;
        }while(true);
        do {
            System.out.println("-----Список покупок------");
            Customer customer = createCustemer();
            System.out.println("Совершить покупку у конкретного продовца? (y/n) ");
            char result = scanner.next().charAt(0);
            if (result == 'y'){
                System.out.print("Имя продавца: ");
                String name = scanner.nextLine();
                scanner.next();
                System.out.print("Фамилия продавца: ");
                String secondName = scanner.nextLine();
                scanner.next();
                customer.findProductOnMarketFindSalesman(market, name, secondName);
            }
            else {
                customer.findProductOnMarket(market);
            }
            customer.whatIBoughtIngo();
            System.out.println("----------------------------");
            System.out.print("Следующий покупатель? (y/n) ");
            char res = scanner.next().charAt(0);
            scanner.nextLine();
            if(res == 'n') break;
        }while(true);
    }
    private static Salesman createSalseman(String name, String secondName, int cash) {
        boolean resultBoolean = true;
        List<Product> productList = new ArrayList<>();
        Salesman salesman = new Salesman(name, secondName, cash, productList);
        do {
            Product product = new Product();

            System.out.print("Наименование продукта: ");
            String nameProduct = scanner.nextLine();
            product.setNameProduct(nameProduct);

            System.out.print("Цена продукта: ");
            int priceProduct = scanner.nextInt();
            product.setPriceProduct(priceProduct);

            System.out.print("Количество продукта:");
            int countProduct = scanner.nextInt();
            product.setCountProduct(countProduct);

            salesman.addProductList(product);

            System.out.println("Добавить продукт? (y/n) ");
            char result = scanner.next().charAt(0);
            scanner.nextLine();

            if(result == 'n') {
                resultBoolean = false;
            }
        }while(resultBoolean);
        return salesman;
    }
    private static Customer createCustemer(){
        List<Product> productList = new ArrayList<>();
        do {
            System.out.print("Наименование продукта: ");
            String name = scanner.nextLine();
            System.out.print("Необходимое количество: ");
            int count = scanner.nextInt();
            Product product = new Product(name, count);
            productList.add(product);
            System.out.print("Добавить продукт? (y/n) ");
            char res = scanner.next().charAt(0);
            scanner.nextLine();
            if(res == 'n') break;
        }while(true);
        System.out.print("Количество денег: ");
        int cash = scanner.nextInt();
        return new Customer(productList, cash);
    }

}
