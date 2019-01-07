package com.codecool.servlet;

public class Item {
    public static int staticId=1;
    private int id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = staticId++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getId(){
        return id;
    }
}
