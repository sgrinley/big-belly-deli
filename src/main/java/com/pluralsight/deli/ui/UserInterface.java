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
        displayWelcomeBanner();
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("     \uD83E\uDD6A BIG BELLY DELI HOME SCREEN \uD83E\uDD6A     ");
            System.out.println("==========================================");
            System.out.println("  1) 🛒 Start New Order");
            System.out.println("  0) ❌ Exit Application");
            System.out.print("👉 Select an option: ");
            String option = scanner.nextLine().trim();

            if (option.equals("1")) {
                cart.clear();
                displayOrderMenu();
            } else if (option.equals("0")) {
                System.out.println("\n👋 Thank you for visiting Big Belly Deli! Have a great day!");
                break;
            } else {
                System.out.println("⚠️ Invalid selection. Please try again.");
            }
        }
    }

    private void displayWelcomeBanner() {
        System.out.println(" __ _             ____       _ _            ____       _ _ ");
        System.out.println("/ _(_) __ _      | __ )  ___| | |_   _     |  _ \\  ___| (_)");
        System.out.println("| |_| |/ _` | ___|  _ \\ / _ \\ | | | | | ___| | | |/ _ \\ | |");
        System.out.println("|  _| | (_| ||___| |_) |  __/ | | |_| ||___| |_| |  __/ | |");
        System.out.println("|_| |_|\\__, |    |____/ \\___|_|_|\\__, |    |____/ \\___|_|_|");
        System.out.println("       |___/                     |___/                     ");
    }

    private void displayOrderMenu() {
        while (true) {
            System.out.println("\n------------------------------------------");
            System.out.println("             📝 ORDER MENU 📝             ");
            System.out.println("------------------------------------------");
            System.out.println("  1) 🥪 Add Custom Sandwich");
            System.out.println("  2) 🥤 Add Refreshing Drink");
            System.out.println("  3) 🥔 Add Potato Chips");
            System.out.println("  4) 💳 Proceed to Checkout");
            System.out.println("  0) 🚨 Cancel Entire Order");
            System.out.print("👉 Select an option: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1": menuAddSandwich(); break;
                case "2": menuAddDrink(); break;
                case "3": menuAddChips(); break;
                case "4": menuCheckout(); return;
                case "0":
                    cart.clear();
                    System.out.println("\n❌ Order has been cancelled. Returning to Home Screen.");
                    return;
                default:
                    System.out.println("⚠️ Invalid choice. Please select from the menu.");
            }
        }
    }

    private void menuAddSandwich() {
        System.out.println("\n==========================================");
        System.out.println("        🥪 BUILD YOUR SANDWICH 🥪        ");
        System.out.println("==========================================");

        System.out.print("📏 Select size (4, 8, 12 inches): ");
        String sizeInputRaw = scanner.nextLine().trim();
        String size = sizeInputRaw.replace("\"", "");

        System.out.print("🥖 Select bread type (White, Wheat, Rye, Wrap, GF Bread): ");
        String bread = scanner.nextLine().trim();

        System.out.print("🔥 Would you like it toasted? (y/n): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // 1. MEAT SELECTION
        System.out.println("\n[Step 1 of 5] 🥩 Meat Options");
        System.out.print("👉 Enter choice (Steak, Ham, Salami, Roast Beef, Chicken, Bacon - or press Enter to skip): ");
        String meat = scanner.nextLine().trim();
        if (!meat.isBlank()) {
            sandwich.addTopping(new Toppings(meat, "MEAT"));
            System.out.print("➕ Add extra meat? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) sandwich.setExtraMeat(true);
        }

        // 2. CHEESE SELECTION
        System.out.println("\n[Step 2 of 5] 🧀 Cheese Options");
        System.out.print("👉 Enter choice (American, Provolone, Cheddar, Swiss - or press Enter to skip): ");
        String cheese = scanner.nextLine().trim();
        if (!cheese.isBlank()) {
            sandwich.addTopping(new Toppings(cheese, "CHEESE"));
            System.out.print("➕ Add extra cheese? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) sandwich.setExtraCheese(true);
        }

        // 3. REGULAR TOPPINGS SELECTION
        System.out.println("\n[Step 3 of 5] 🥗 Free Regular Toppings");
        System.out.println("💡 Options: Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumbers, Pickles, Guacamole, Mushrooms");
        System.out.print("👉 Enter toppings (comma separated, or press Enter to skip): ");
        String regularInput = scanner.nextLine().trim();
        if (!regularInput.isBlank()) {
            for (String top : regularInput.split(",")) {
                sandwich.addTopping(new Toppings(top.trim(), "REGULAR"));
            }
        }

        // 4. SAUCES SELECTION
        System.out.println("\n[Step 4 of 5] 🍯 Free Premium Sauces");
        System.out.println("💡 Options: Mayo, Mustard, Ketchup, Ranch, Thousand Islands, Vinaigrette");
        System.out.print("👉 Enter sauces (comma separated, or press Enter to skip): ");
        String sauceInput = scanner.nextLine().trim();
        if (!sauceInput.isBlank()) {
            for (String s : sauceInput.split(",")) {
                sandwich.addTopping(new Toppings(s.trim(), "SAUCE"));
            }
        }

        // 5. SIDES SELECTION
        System.out.println("\n[Step 5 of 5] 🍟 Free Side Items");
        System.out.println("💡 Options: Au Jus, Sauce Cup");
        System.out.print("👉 Enter sides (comma separated, or press Enter to skip): ");
        String sideInput = scanner.nextLine().trim();
        if (!sideInput.isBlank()) {
            for (String side : sideInput.split(",")) {
                sandwich.addTopping(new Toppings(side.trim(), "SIDE"));
            }
        }

        // TOPPING REMOVAL OPTION
        handleToppingRemoval(sandwich);

        cart.add(sandwich);
        System.out.println("\n🎉 Sandwich successfully added to your order cart!");
    }

    private void handleToppingRemoval(Sandwich sandwich) {
        System.out.println("\n------------------------------------------");
        System.out.println("         🛠️ EDIT SANDWICH TOPPINGS        ");
        System.out.println("------------------------------------------");
        System.out.print("🔄 Would you like to remove any ingredients? (y/n): ");
        if (!scanner.nextLine().equalsIgnoreCase("y")) {
            return;
        }

        while (true) {
            System.out.print("❌ Enter the exact name of the item to remove (or press Enter to finish): ");
            String toRemove = scanner.nextLine().trim();

            if (toRemove.isBlank()) {
                break;
            }

            sandwich.removeTopping(toRemove);
            System.out.println("✨ '" + toRemove + "' has been processed for removal.");
        }
    }

    private void menuAddDrink() {
        System.out.println("\n==========================================");
        System.out.println("            🥤 ADD A DRINK 🥤            ");
        System.out.println("==========================================");
        System.out.print("📏 Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine().trim();
        System.out.print("🍹 Select drink flavor (Berry Bliss, Mango Jango, Tamarind Refresher, Tropical Rhythm): ");
        String flavor = scanner.nextLine().trim();

        cart.add(new Drink(size, flavor));
        System.out.println("\n🎉 Drink successfully added to your order cart!");
    }

    private void menuAddChips() {
        System.out.println("\n==========================================");
        System.out.println("            🥔 ADD CHIPS 🥔            ");
        System.out.println("==========================================");
        System.out.print("🍟 Select chips type (Regular, BBQ, Sour Cream): ");
        String type = scanner.nextLine().trim();

        cart.add(new Chips(type));
        System.out.println("\n🎉 Chips successfully added to your order cart!");
    }

    private void menuCheckout() {
        System.out.println("\n==========================================");
        System.out.println("         💳 COMPLETE CHECKOUT 💳          ");
        System.out.println("==========================================");
        double total = 0.0;

        for (Orderable item : cart) {
            System.out.println(item.getDetails());
            System.out.printf("   💵 Price: $%.2f\n", item.getPrice());
            System.out.println("------------------------------------------");
            total += item.getPrice();
        }

        System.out.printf("\n💰 FINAL ORDER TOTAL: $%.2f\n", total);
        System.out.print("✅ Confirm and finalize payment? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            Receipt.saveReceipt(cart, total);
            System.out.println("\n🎉 Success! Your receipt has been securely saved to your local folder.");
        } else {
            System.out.println("\n✋ Order checkout suspended. Cart items preserved.");
        }
    }
}