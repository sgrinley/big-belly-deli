package com.pluralsight.deli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChipsTest {
    @Test
    public void getPrice_AnyChips_ReturnsOneFiftyFive() {
        // 1. Arrange: Create regular, BBQ and Sour Cream chips items
        Chips regularChips = new Chips("Regular");
        Chips bbqChips = new Chips("BBQ");
        Chips sourCreamChips = new Chips("Sour Cream");

        // 2. Act & Assert: Verify cost $1.55
        assertEquals(1.55, regularChips.getPrice(), 0.001, "Regular chips must equal $1.55");
        assertEquals(1.55, bbqChips.getPrice(), 0.001, "BBQ chips must equal $1.55");
        assertEquals(1.55, sourCreamChips.getPrice(), 0.001, "Sour Cream chips must equal $1.55");
    }
}

