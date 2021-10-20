package com.geekbrains.java.lesson8.person;

import com.geekbrains.java.lesson8.Market;
import com.geekbrains.java.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private List<Product> purchaseList;
    private List<Product> weWannaBuyProduct;

    public Customer(List<Product> weWannaBuyProduct,int cash){
        setWeWannaBuyProduct(weWannaBuyProduct);
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

    public  void addWeWannaBuyList(Product product){
        if(weWannaBuyProduct == null){
            weWannaBuyProduct = new ArrayList<>();
        }
        weWannaBuyProduct.add(product);
    }
    public void whatIBoughtIngo(){
        System.out.println();
        //if (purchaseList != null) {
            StringBuilder stringBuilder = new StringBuilder("Я купил: \n");
            for (Product product : purchaseList) {
                stringBuilder.append(product.getNameProduct());
                stringBuilder.append(" в количестве ");
                stringBuilder.append(product.getCountProduct());
                stringBuilder.append(" шт.\n");
            }
            stringBuilder.append("У меня осталось: ");
            stringBuilder.append(getCash());
            stringBuilder.append(" рублей.");
            System.out.println(stringBuilder);
    //    }
    //    else System.out.printf("%s рублей(я) не хватило на покупки", getCash());
    }

    public void findProductOnMarket(Market market) {
        for (Salesman salesman: market.getSalesmanList()){
            boolean isBought = salesman.sellProducts(this, getWeWannaBuyProduct(), market);
            if(isBought) continue;
        }
    }
    public void findProductOnMarketFindSalesman(Market market, String name, String secondName) {
        for (Salesman salesman: market.getSalesmanList()){
            if(salesman.getNameSalesman().equals(name) && salesman.getSecondNameSalesman().equals(secondName)) {
                boolean isBought = salesman.sellProductsSalesman(this, getWeWannaBuyProduct());
                if (isBought) continue;
            }
        }
        if(getPurchaseList() != getWeWannaBuyProduct()) {
            findProductOnMarket(market);
        }
    }

    public List<Product> getWeWannaBuyProduct() {
        return weWannaBuyProduct;
    }

    public void setWeWannaBuyProduct(List<Product> weWannaBuyProduct) {
        this.weWannaBuyProduct = weWannaBuyProduct;
    }
}
