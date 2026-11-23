package com.ritik.wishlist.model;

import java.io.Serializable;

public class WishlistItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private String name;
    private double price;
    private String category;
    private int quantity;

    public WishlistItem(String id, String name, double price, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getLineTotal() { return price * quantity; }

    @Override
    public String toString() {
        return String.format("%-6s | %-24s | Rs. %9.2f | %-14s | %3d | Rs. %10.2f",
                id, name, price, category, quantity, getLineTotal());
    }
}
