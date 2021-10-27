package com.jdbc.model;

public class Product {

    private String productName;
    private int amount;

    public Product(String productName, int amount) {
        this.productName = productName;
        this.amount = amount;
    }

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

    @Override
    public String toString() {
        return "Order includes " + amount + " amount of product " + productName;
    }
}