package com.geekbrains.java.lesson8;

import com.geekbrains.java.lesson8.person.Customer;
import com.geekbrains.java.lesson8.person.Salesman;
import com.geekbrains.java.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        List<Salesman> salesmanList= new ArrayList<>();
        salesmanList.add(createFirstSalseman("Вася", "Пупкин", 0));
        salesmanList.add(createFirstSalseman("Олег", "Капск", 0));

        Customer customer = new Customer(90);
        for(Salesman salesman: salesmanList){
            salesman.sellProducts(customer, "Огурцы", 10);
        }
        customer.whatIBoughtIngo();


    }
    private static Salesman createFirstSalseman(String name, String secondName, int cash) {
        Product firstProduct = new Product("Помидоры", 10, 20);
        Product secondProuct = new Product("Огурцы", 8, 100);
        List<Product> productList = new ArrayList<>();
        productList.add(firstProduct);
        productList.add(secondProuct);
        Salesman salesman = new Salesman(name, secondName, cash, productList);
        return salesman;
    }

}
