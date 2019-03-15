package com.javarush.task.task18.task1828;

import java.util.Locale;

public class Products {
    private int id;
    private String productName;
    private float price;
    private int quantity;

    public Products(String id, String productName, String price, String quantity) {
        this.id = Integer.parseInt(id.trim());
        this.productName = productName.trim();
        this.price = Float.parseFloat(price.replace(",", ".").trim());
        this.quantity = Integer.parseInt(quantity.trim());
    }

    public Products(int id, String productName, String price, String quantity) {
        this.id = id;
        this.productName = productName.trim();
        this.price = Float.parseFloat(price.replace(",", ".").trim());
        this.quantity = Integer.parseInt(quantity.trim());
    }

    public void updateProduct(String productName, String price, String quantity){
        this.productName = productName.trim();
        this.price = Float.parseFloat(price.trim());
        this.quantity = Integer.parseInt(quantity.trim());
    }

    public String getProductString(){
        return getIdString() + getProductNameString() + getPriceString() + getQuantityString();
    }

    private String getIdString(){
        return String.format("%-8s", this.id);
    }

    private String getProductNameString(){
        return String.format("%-30s", this.productName);
    }

    private String getPriceString(){
        return String.format(Locale.ENGLISH,"%-8.2f", this.price);
    }

    private String getQuantityString(){
        return String.format("%-4s", this.quantity);
    }

    public int getId() {
        return id;
    }




}
