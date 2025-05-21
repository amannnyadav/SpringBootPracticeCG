package org.cg.shoppingcart;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity=100;

    public Product() {}

    public Product(String id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
