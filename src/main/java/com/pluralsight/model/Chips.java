package com.pluralsight.model;

import com.pluralsight.Orderable;

public class Chips implements Orderable {
    private String type; // Regular, BBQ, Sour Cream

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 1.50; // Flat rate for chips as per requirements
    }

    @Override
    public String getDetails() {
        return type + " Chips";
    }
}