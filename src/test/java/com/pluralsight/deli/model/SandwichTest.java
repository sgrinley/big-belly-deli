package com.pluralsight.deli.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SandwichTest {

    @Test
    public void getPrice_FourInchSandwichNoToppings_ReturnsBasePrice() {
        // Arrange
        Sandwich sandwich = new Sandwich("4", "White", false);
        // Act
        double price = sandwich.getPrice();
        // Assert ($5.50 base price)
        assertEquals(5.50, price, 0.001, "A baseline 4-inch sandwich should cost $5.50");
    }

    @Test
    public void getPrice_EightInchSandwichNoToppings_ReturnsBasePrice() {
        // Arrange
        Sandwich sandwich = new Sandwich("8", "Wheat", false);
        // Act
        double price = sandwich.getPrice();
        // Assert ($7.00 base price)
        assertEquals(7.00, price, 0.001, "A baseline 8-inch sandwich should cost $7.00");
    }

    @Test
    public void getPrice_TwelveInchSandwichNoToppings_ReturnsBasePrice() {
        // Arrange
        Sandwich sandwich = new Sandwich("12", "Rye", false);
        // Act
        double price = sandwich.getPrice();
        // Assert ($8.50 base price)
        assertEquals(8.50, price, 0.001, "A baseline 12-inch sandwich should cost $8.50");
    }

    @Test
    public void removeTopping_ExistingTopping_SuccessfullyRemovesItem() {
        // Arrange
        Sandwich sandwich = new Sandwich("8", "Wheat", false);
        Toppings lettuce = new Toppings("Lettuce", "REGULAR");
        sandwich.addTopping( lettuce );

        // Act
        sandwich.removeTopping("Lettuce");

        // Assert
        assertFalse(sandwich.getDetails().contains("Lettuce"), "Lettuce should be removed from the sandwich details");
    }
}