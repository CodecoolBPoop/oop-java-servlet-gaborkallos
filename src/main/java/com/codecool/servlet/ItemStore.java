package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {

    private static List<Item> items = new ArrayList<>();

    public static List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        for (Item elem : items) {
            if (elem.equals(item)) {
                items.remove(elem);
            }
        }
    }

    public String init() {
        StringBuffer result = new StringBuffer();
        for (Item elem : items) {
            result.append("<tr>");
            result.append("<td class=\"text-left\">" + elem.getName() + "</td>");
            result.append("<td class=\"text-right\"> $" + elem.getPrice() + "</td>");
            result.append("<form action=\"/webshop\" method=\"get\">");
            result.append("<td class=\"text-center\"><button type=\"submit\" value=" + elem.getId() + " name=\"add\"> Add </button></td>");
            result.append("<td class=\"text-center\"><button type=\"submit\" value=" + elem.getId() + " name=\"remove\"> Remove </button></td>");
            result.append("</tr>");
            result.append("</form>");

        }
        return result.toString();
    }

    public void clearItems() {
        items.clear();
        Item.staticId = 1;
    }

    public Item findItem(int id) {
        for (Item item : items) {
            System.err.println(item.getId());
            if (item.getId() == id) {
                System.err.println(item.getName());
                return item;
            }
        }
        return null;
    }
}
