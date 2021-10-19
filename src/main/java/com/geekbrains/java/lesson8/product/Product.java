package com.geekbrains.java.lesson8.product;

public class Product {
    private String nameProduct;
    private int priceProduct;
    private int countProduct;

    public Product(){

    }
    public Product(String name, int price, int count){
        setNameProduct(name);
        setPriceProduct(price);
        setCountProduct(count);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }
}
