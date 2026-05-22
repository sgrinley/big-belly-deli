package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    //    Add Data Fields
    private String size; // 4", 8", 12"
    private String breadType; // White, Wheat, Rye, Wrap, Gluten Free (GF)
    private boolean isToasted;

    //    Lists of Toppings
    private List<String> meatToppings;
    private List<String> cheeseToppings;
    private List<String> regularToppings;
    private List<String> premiumToppings;
    private List<String> sauces;

    private boolean extraMeat;
    private boolean extraCheese;
    private boolean extraSauce;

    //    Generate Constructor
    public Sandwich(String size, String breadType, boolean isToasted, List<String> meatToppings, List<String> cheeseToppings, List<String> regularToppings, List<String> premiumToppings, List<String> sauces) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.meatToppings = new ArrayList<>();
        this.cheeseToppings = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }
    //  Generate Getters & Setters
    public void addMeat(String meat) {meatToppings.add(meat);}
    public void addCheese(String cheese) {cheeseToppings.add(cheese);}
    public void addRegularToppings(String toppings) {regularToppings.add(toppings);}
    public void addPremiumToppings(String toppings) {premiumToppings.add(toppings);}
    public void addSauce(String sauce) {sauces.add(sauce);}

    public void setExtraSauce(boolean extraSauce) {this.extraSauce = extraSauce;}
    public void setExtraCheese(boolean extraCheese) {this.extraCheese = extraCheese;}
    public void setExtraMeat(boolean extraMeat) {this.extraMeat = extraMeat;}

    //    Add Switch Case
    @Override
    public double getPrice() {
        double price = 0.0;

        //     Bread sizes & prices
        switch (size){
            case "4\"": price += 5.50; break;
            case "8\"": price += 7.00; break;
            case "12\"": price += 8.50; break;
        }

        //      Premium meat prices
        if (!meatToppings.isEmpty()) {
            switch (size) {
                case "4\"": price += 1.00; break;
                case "8\"": price += 2.00; break;
                case "12\"": price += 3.00; break;
            }

            //      Extra meat charges
            if (extraMeat) {
                switch (size) {
                    case "4\"": price += 0.50; break;
                    case "8\"": price += 1.00; break;
                    case "12\"": price += 1.50; break;
                }
            }
        }

        //        Premium cheese prices
        if (!cheeseToppings.isEmpty()) {
            switch (size) {
                case "4\"":  price += 0.75; break;
                case "8\"":  price += 1.50; break;
                case "12\"": price += 2.25; break;
            }
        }
    }
}