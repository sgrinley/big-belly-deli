package com.pluralsight.deli.model;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private List<Orderable> items;

    public void Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Orderable item) {
        this.items.add(item);
    }

    public List<Orderable> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }
}