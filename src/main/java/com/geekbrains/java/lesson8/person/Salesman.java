package com.geekbrains.java.lesson8.person;

import com.geekbrains.java.lesson8.Market;
import com.geekbrains.java.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Salesman extends Person {
    private String nameSalesman;
    private String secondNameSalesman;
    private List<Product> productList;

    public void addProductList(Product product){
        if(productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }

    public boolean sellProducts(Customer customer, List <Product> customerProductList, Market market){
        for (Salesman salesman: market.getSalesmanList()) {

            for (Product productCus : customerProductList) {
                for (Product product : this.productList) {
                    //Проверяем по названию продукта его наличие у продавца
                    if (product.getNameProduct().equals(productCus.getNameProduct())) {
                        //Проверяем есть ли у данного продавца нужное колличество продукта
                        if (product.getCountProduct() >= productCus.getCountProduct()) {
                            //Проверяем хватает ли денег у покупателя на нужное количество продуктов
                            long requiredCash = product.getPriceProduct() * productCus.getCountProduct();
                            if (customer.getCash() >= requiredCash) {
                                customer.setCash((int) (customer.getCash() - requiredCash));

                                this.setCash((int) (this.getCash() + requiredCash));

                                product.setCountProduct(product.getCountProduct() - productCus.getCountProduct());

                                Product customerProduct = new Product();
                                customerProduct.setCountProduct(productCus.getCountProduct());
                                customerProduct.setNameProduct(productCus.getNameProduct());
                                customer.addPurchaseList(customerProduct);

                                return true;
                            }

                        }

                    }

                }
            }
        }
        //System.out.printf("Продукт у продовца %s %s не найден либо его количество мало, или недостаточно денег у покупателя", nameSalesman, secondNameSalesman);
        return false;
    }

    public Salesman(String name, String secondNameSalesman, int cash, List<Product> productList){
        setNameSalesman(name);
        setSecondNameSalesman(secondNameSalesman);
        setCash(cash);
        setProductList(productList);
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    public void setNameSalesman(String nameSalesman) {
        this.nameSalesman = nameSalesman;
    }

    public String getSecondNameSalesman() {
        return secondNameSalesman;
    }

    public void setSecondNameSalesman(String secondNameSalesman) {
        this.secondNameSalesman = secondNameSalesman;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public boolean sellProductsSalesman(Customer customer, List <Product> customerProductList){
        for (Product productCus : customerProductList) {
            for (Product product : this.productList) {
                //Проверяем по названию продукта его наличие у продавца
                if (product.getNameProduct().equals(productCus.getNameProduct())) {
                    //Проверяем есть ли у данного продавца нужное колличество продукта
                    if (product.getCountProduct() >= productCus.getCountProduct()) {
                        //Проверяем хватает ли денег у покупателя на нужное количество продуктов
                        long requiredCash = product.getPriceProduct() * productCus.getCountProduct();
                        if (customer.getCash() >= requiredCash) {
                            customer.setCash((int) (customer.getCash() - requiredCash));
                            this.setCash((int) (this.getCash() + requiredCash));
                            product.setCountProduct(product.getCountProduct() - productCus.getCountProduct());
                            Product customerProduct = new Product();
                            customerProduct.setCountProduct(productCus.getCountProduct());
                            customerProduct.setNameProduct(productCus.getNameProduct());
                            customer.addPurchaseList(customerProduct);
                            return true;
                        }
                    }
                }
            }
        }
        System.out.printf("Продукт у продовца %s %s не найден либо его количество мало, или недостаточно денег у покупателя", nameSalesman, secondNameSalesman);
        return false;
    }
}
