package com.pluralsight.deli.ui;

import com.pluralsight.deli.data.Receipt;
import com.pluralsight.deli.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Orderable> cart = new ArrayList<>();

    public void run() {
        while (true) {
            System.out.println("\n--- DELI-cious Home Screen ---");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                cart.clear();
                displayOrderMenu();
            } else if (option.equals("0")) {
                System.out.println("Thank you for shopping!");
                break;
            } else {
                System.out.println("Invalid selection. Try again");
            }
        }
    }

    private void displayOrderMenu() {
        while (true) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1": menuAddSandwich(); break;
                case "2": menuAddDrink(); break;
                case "3": menuAddChips(); break;
                case "4": menuCheckout(); return;
                case "0":
                    cart.clear();
                    System.out.println("Order has been cancelled.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void menuAddSandwich() {
        System.out.println("\n--- Build Your Sandwich ---");
        System.out.print("Select size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();
        System.out.print("Select bread (White, Wheat, Rye, Wrap, GF Bread): ");
        String bread = scanner.nextLine();
        System.out.print("Would you like it toasted? (y/n): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.print("Enter meat (Steak, Ham, Salami, Roast Beef, Chicken, Bacon - leave blank to skip): ");
        String meat = scanner.nextLine();
        if (!meat.isBlank()) {
            sandwich.addTopping(new Toppings(meat, "MEAT"));
            System.out.print("Add extra meat? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) sandwich.setExtraMeat(true);
        }

        System.out.print("Enter cheese (American, Provolone, Cheddar, Swiss - leave blank to skip): ");
        String cheese = scanner.nextLine();
        if (!cheese.isBlank()) {
            sandwich.addTopping(new Toppings(cheese, "CHEESE"));
            System.out.print("Add extra cheese? (y/n): "); // Bug fixed: now looks uniformly for "y"
            if (scanner.nextLine().equalsIgnoreCase("y")) sandwich.setExtraCheese(true);
        }

        System.out.print("Enter regular toppings (e.g. Lettuce, Tomatoes, Onions, Pickles, Peppers - comma separated or leave blank): ");
        String regularInput = scanner.nextLine();
        if (!regularInput.isBlank()) {
            for (String top : regularInput.split(",")) {
                sandwich.addTopping(new Toppings(top.trim(), "REGULAR"));
            }
        }

        System.out.print("Enter sauces (e.g. Mayo, Mustard, Ketchup, Ranch  - comma separated or leave blank): ");
        String sauceInput = scanner.nextLine();
        if (!sauceInput.isBlank()) {
            for (String s : sauceInput.split(",")) {
                sandwich.addTopping(new Toppings(s.trim(), "SAUCE"));
            }
        }

        cart.add(sandwich);
        System.out.println("Sandwich successfully added to your order!");
    }

    private void menuAddDrink() {
        System.out.print("Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();
        System.out.print("Select drink flavor (Berry Bliss, Mango Jango, Tamarind Refresher, Tropical Rhythm: ");
        String flavor = scanner.nextLine();

        cart.add(new Drinks(size, flavor));
        System.out.println("Drink successfully added to your order!");
    }

    private void menuAddChips() {
        System.out.print("Select chips type (Regular, BBQ, Sour Cream): ");
        String type = scanner.nextLine();

        cart.add(new Chips(type));
        System.out.println("Chips successfully added to your order!");
    }

    private void menuCheckout() {
        System.out.println("\n=== Complete Checkout ===");
        double total = 0.0;

        for (Orderable item : cart) {
            System.out.println(item.getDetails());
            System.out.printf("  Price: $%.2f\n\n", item.getPrice());
            total += item.getPrice();
        }

        System.out.printf("Order Total Summary: $%.2f\n", total);
        System.out.print("Confirm and finalize payment? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            Receipt.saveReceipt(cart, total);
        } else {
            System.out.println("Order checkout suspended.");
        }
    }
}