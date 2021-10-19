package com.geekbrains.java.lesson8.person;

import com.geekbrains.java.lesson8.product.Product;

import java.util.List;

public class Salesman extends Person {
    private String nameSalesman;
    private String secondNameSalesman;
    private List<Product> productList;

    public boolean sellProducts(Customer customer, String weWannaBuyName, int weWannaBuyCount){
        for(Product product: productList){
            //Проверяем по названию продукта его наличие у продавца
            if(product.getNameProduct().equals(weWannaBuyName)){
                //Проверяем есть ли у данного продавца нужное колличество продукта
                if(product.getCountProduct() >= weWannaBuyCount){
                    //Проверяем хватает ли денег у покупателя на нужное количество продуктов
                    long requiredCash = product.getPriceProduct()*weWannaBuyCount;
                    if(customer.getCash()>= requiredCash){
                        customer.setCash((int) (customer.getCash() - requiredCash));

                        this.setCash((int)(this.getCash() + requiredCash));

                        product.setCountProduct(product.getCountProduct() - weWannaBuyCount);

                        Product customerProduct = new Product();
                        customerProduct.setCountProduct(weWannaBuyCount);
                        customerProduct.setNameProduct(weWannaBuyName);
                        customer.addPurchaseList(customerProduct);
                        return true;
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
}
