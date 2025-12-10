package com.projects.stockDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Product product;

    // Constructor
    public StockItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    // Default constructor for JPA
    public StockItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int increaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to increase must be positive.");
        } else {
            this.quantity += amount;
        }
        return this.quantity;
    }

    public int decreaseQuantity(int amount) {
        if (amount <= 0 || amount > this.quantity) {
            throw new IllegalArgumentException(
                    "Amount to decrease must be positive and less than or equal to current quantity.");
        } else {
            this.quantity -= amount;
        }
        return this.quantity;
    }
}
