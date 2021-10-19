package com.geekbrains.java.lesson8.person;

import com.geekbrains.java.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private List<Product> purchaseList;
    public Customer(int cash){
        setCash(cash);
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }
    public void addPurchaseList(Product product){
        if(purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);

    }
    public void whatIBoughtIngo(){
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder("Я купил: ");
        for(Product product: this.purchaseList){
            stringBuilder.append(product.getNameProduct());
            stringBuilder.append(" в количестве ");
            stringBuilder.append(product.getCountProduct());
            System.out.println();
        }
        stringBuilder.append(". У меня осталось: ");
        stringBuilder.append(getCash());
        stringBuilder.append(" рублей.");
        System.out.println(stringBuilder);
    }
}
