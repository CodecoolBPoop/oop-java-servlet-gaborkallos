package com.codecool.servlet;

public class Stock {
    public static ItemStore stock = new ItemStore();

    static {
        stock.add(new Item("Asus Laptop", 1600));
        stock.add(new Item("Lenovo Laptop", 1620));
        stock.add(new Item("Samsung Tablet", 300));
        stock.add(new Item("Game of Thrones Ebook", 55));
        stock.add(new Item("Harry Potter Ebook", 50));
    }

}
