package com.kiyotakeshi.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {

    private int totalAmount = 0;

    private List<Product> items = new ArrayList<>();

    public void addToCart(Product p) {
        items.add(p);
        totalAmount = totalAmount + p.getPrice();
    }

    public List<Product> getItems() {
        return items;
    }

    int getTotalAmount() {
        return totalAmount;
    }

    public void removeFromCart(Product p) {
        items.remove(p);
        totalAmount = totalAmount - p.getPrice();
    }

    void printCartDetails() {
        System.out.println("Here are your shopping cart items:");
        for (Product p : getItems()) {
            System.out.println("---------------");
            System.out.println("Product ID: " + p.getId());
            System.out.println("Product Name: " + p.getName());
            System.out.println("Product Description: " + p.getDescription());
            System.out.println("Product Price: $" + p.getPrice());
            System.out.println("---------------");
        }
    }
}
