package com.projects.stockDemo.model;

public class FoodProduct extends Product {

    private String expirationDate;

    public FoodProduct(Long id, String name, int price, Category category, String expirationDate) {
        super(id, name, price, category);
        this.expirationDate = expirationDate;

    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " EXPIRATION DATE: " + expirationDate;
    }
}
