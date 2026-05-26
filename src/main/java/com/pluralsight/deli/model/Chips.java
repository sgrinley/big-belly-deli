package com.pluralsight.deli.model;

public class Chips implements Orderable {
    private final String chipsType; // Regular, BBQ, Sour Cream

    public Chips(String chipsType) {
        this.chipsType = chipsType;
    }

    @Override
    public double getPrice() {
        return 1.55; // Standard price for chips
    }

    @Override
    public String getDetails() {
        return chipsType + " Chips";
    }
}