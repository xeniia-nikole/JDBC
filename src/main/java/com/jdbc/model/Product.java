package com.jdbc.model;

public class Product {

    private String productName;
    private int amount;
    private String date;


    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Product setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Product setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
