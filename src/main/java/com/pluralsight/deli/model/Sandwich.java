package com.pluralsight.deli.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Orderable {
    private final String size;
    private final String breadType;
    private final boolean isToasted;

    private final List<Toppings> toppings;

    private boolean extraMeat;
    private boolean extraCheese;

    // Generate Constructor (Assigns parameters to fields and initializes list)
    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Toppings toppings) {
        this.toppings.add(toppings);
    }

    // ADD REMOVAL METHOD
    public void removeTopping(String toppingName) {
        // Looks through the toppings list and removes any item matching the name (ignoring case)
        this.toppings.removeIf(t -> t.name().equalsIgnoreCase(toppingName.trim()));
    }

    public void setExtraMeat(boolean extraMeat) { this.extraMeat = extraMeat; }
    public void setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; }

    @Override
    public double getPrice() {
        double price = 0.0;

        switch (size) {
            case "4":  price += 5.50; break;
            case "8":  price += 7.00; break;
            case "12": price += 8.50; break;
        }

        // 2. Delegate price logic loop to the topping objects
        boolean countedFirstMeat = false;
        boolean countedFirstCheese = false;

        for (Toppings t : toppings) {
            if (t.type().equals("MEAT") && !countedFirstMeat) {
                price += t.getBasePrice(size);
                countedFirstMeat = true;
            } else if (t.type().equals("CHEESE") && !countedFirstCheese) {
                price += t.getBasePrice(size);
                countedFirstCheese = true;
            }
        }

        // 3. Apply extra item upgrades safely
        if (extraMeat)  price += new Toppings("", "MEAT").getExtraPrice(size);
        if (extraCheese) price += new Toppings("", "CHEESE").getExtraPrice(size);

        return price;
    }

    @Override
    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(breadType).append(" Sandwich"); // Added back a quote label for display consistency
        if (isToasted) sb.append(" (Toasted)");

        // Organize outputs on demand
        List<String> meatNames = new ArrayList<>();
        List<String> cheeseNames = new ArrayList<>();
        List<String> regularNames = new ArrayList<>();
        List<String> sauceNames = new ArrayList<>();
        List<String> sideNames = new ArrayList<>(); // Added list for free sides

        for (Toppings t : toppings) {
            switch (t.type()) {
                case "MEAT":    meatNames.add(t.name()); break;
                case "CHEESE":  cheeseNames.add(t.name()); break;
                case "REGULAR": regularNames.add(t.name()); break;
                case "SAUCE":   sauceNames.add(t.name()); break;
                case "SIDE":    sideNames.add(t.name()); break; // Catching sides here
            }
        }

        sb.append("\n    Meats: ").append(meatNames.isEmpty() ? "None" : String.join(", ", meatNames));
        if (extraMeat) sb.append(" [Extra Meat]");
        sb.append("\n    Cheeses: ").append(cheeseNames.isEmpty() ? "None" : String.join(", ", cheeseNames));
        if (extraCheese) sb.append(" [Extra Cheese]");
        sb.append("\n    Regular Toppings: ").append(regularNames.isEmpty() ? "None" : String.join(", ", regularNames));
        sb.append("\n    Sauces: ").append(sauceNames.isEmpty() ? "None" : String.join(", ", sauceNames));
        sb.append("\n    Sides: ").append(sideNames.isEmpty() ? "None" : String.join(", ", sideNames)); // Prints sides on receipt

        return sb.toString();
    }
}