package com.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "carts")
public class Cart {
    @Id
    private String cartId;
    private List<Item> items;
    private double total;
    private String status;

    public Cart() {
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.status = "ACTIVE";
    }

    public Cart(String cartId, List<Item> items, double total, String status) {
        this.cartId = cartId;
        this.items = items != null ? items : new ArrayList<>();
        this.total = total;
        this.status = status;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
