package com.pluralsight.deli.model;

public class Drink implements Orderable {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // FIXED: Added @Override to explicitly satisfy the Orderable contract
    @Override
    public double getPrice() {
        // Safe check to prevent unexpected crashes if size is missing
        if (size == null) {
            return 0.0;
        }

        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.00;
        };
    }

    @Override
    public String getDetails() {
        return size + " " + flavor + " Drink";
    }
}