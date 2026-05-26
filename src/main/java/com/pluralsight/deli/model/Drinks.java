package com.pluralsight.deli.model;

public class Drinks implements Orderable {
    private String size;
    private String flavor;

    public void Drink(String size, String flavor) {
    }
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.00;
        }
    }

    @Override
    public String getDetails() {
        return size + " " + flavor + " Drink";
    }
}