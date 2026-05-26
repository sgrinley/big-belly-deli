package com.pluralsight.deli.model;

public class Toppings {
    private final String name;
    private final String type; // "MEAT", "CHEESE", "REGULAR", "SAUCE"

    public Toppings(String name, String type) {
        this.name = name;
        this.type = type.toUpperCase();
    }

    public String getName() { return name; }
    public String getType() { return type; }

    /**
     * Calculates the premium topping base price depending on the sandwich size.
     */
    public double getBasePrice(String size) {
        if (type.equals("MEAT")) {
            switch (size) {
                case "4\"":  return 1.00;
                case "8\"":  return 2.00;
                case "12\"": return 3.00;
            }
        } else if (type.equals("CHEESE")) {
            switch (size) {
                case "4\"":  return 0.75;
                case "8\"":  return 1.50;
                case "12\"": return 2.25;
            }
        }
        return 0.0; // Regular toppings, sauces, and sides are $0.00
    }

    /**
     * Calculates the upgrade cost for adding extra premium toppings.
     */
    public double getExtraPrice(String size) {
        if (type.equals("MEAT")) {
            switch (size) {
                case "4\"":  return 0.50;
                case "8\"":  return 1.00;
                case "12\"": return 1.50;
            }
        } else if (type.equals("CHEESE")) {
            switch (size) {
                case "4\"":  return 0.30;
                case "8\"":  return 0.60;
                case "12\"": return 0.90;
            }
        }
        return 0.0;
    }
}

