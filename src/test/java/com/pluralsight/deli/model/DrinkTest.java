package com.pluralsight.deli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkTest {
    @Test
    public void getPrice_SmallDrink_ReturnsTwoDollars() {
        // 1. Arrange: Create a small drink object matching your model
        Drink smallDrink = new Drink("Small", "Berry Bliss");

        // 2. Act: Call the getPrice() method we want to test
        double price = smallDrink.getPrice();

        // 3. Assert: Verify the price matches the $2.00 requirement exactly
        assertEquals(2.00, price, 0.001, "A small drink should cost exactly $2.00");
    }
    @Test
    public void getPrice_MediumDrink_ReturnsTwoFifty() {
        // Arrange: Create a medium drink
        Drink mediumDrink = new Drink("Medium", "Mango Jango");

        // Act: Get the price
        double price = mediumDrink.getPrice();

        // Assert: Verify it's $2.50
        assertEquals(2.50, price, 0.001, "A medium drink should cost exactly $2.50");
    }

    @Test
    public void getPrice_LargeDrink_ReturnsThreeDollars() {
        // Arrange: Create a large drink
        Drink largeDrink = new Drink("Large", "Tropical Rhythm");

        // Act: Get the price
        double price = largeDrink.getPrice();

        // Assert: Verify it's $3.00
        assertEquals(3.00, price, 0.001, "A large drink should cost exactly $3.00");
    }
}

