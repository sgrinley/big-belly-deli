package com.pluralsight.model;

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
    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }
}
