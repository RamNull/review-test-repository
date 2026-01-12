package com.example.cartservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Item {
    @NotBlank(message = "Item name is required")
    private String name;
    
    @Positive(message = "Price must be positive")
    private double price;
    
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    public Item() {
    }

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
