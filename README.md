# Big Belly Deli - Console Ordering Application

Welcome to the **Big Belly Deli** application! This is a robust, console-based point-of-sale (POS) system built in Java. The application allows customers to build custom sandwiches with detailed topping options, choose drinks and sides, dynamically review their cart with real-time pricing math, and automatically generate formatted text receipts.

---

## 🚀 Key Features

- **Dynamic Sandwich Customization:** Customers can choose from multiple sizes (4", 8", 12") and bread types, select toasted options, and stack premium or regular toppings.
- **User-Friendly Navigation:** - **Skip Options:** Optional fields (meats, cheeses, regular toppings, sauces, and sides) can be skipped entirely by pressing `Enter`.
    - **Real-Time Removal:** A dedicated topping modification flow allows users to edit their minds and strip individual toppings away via dynamic list filtering before saving to the cart.
- **Diverse Side Items:** Support for custom drink sizes and flavors alongside multiple chips profiles.
- **Automated Pricing Engine:** Implements a strict matrix tracking base size scales, premium additions, and extra meat/cheese upgrades without mathematical rounding discrepancies.
- **Persistent Receipt Logging:** Finalizing an order exports a clean, human-readable file timestamped inside a local data path.

---

## 🛠️ Architecture & Design Patterns

The project leverages clean **Object-Oriented Programming (OOP)** paradigms to keep the codebase modular, maintainable, and highly professional:

- **Interface Segregation (`Orderable`):** Applied to isolate pricing (`getPrice()`) and descriptive output (`getDetails()`) rules uniformly across all menu components (`Sandwich`, `Drink`, `Chips`).
- **Encapsulation & Records (`Toppings`):** Implemented lightweight immutable structures to track names and category tags (`MEAT`, `CHEESE`, `REGULAR`, `SAUCE`, `SIDE`) securely.
- **List and Stream Filtering:** Utilizes advanced collection workflows (`removeIf`) alongside case-insensitive matching to guarantee real-time item deletion mechanics function reliably.
- **Clean Model-View-Controller Split:** Separates execution code layers neatly across packages:
    - `com.pluralsight.deli.model` (Business Core Logic)
    - `com.pluralsight.deli.ui` (User Interface Loops)
    - `com.pluralsight.deli.data` (File Handling & Receipt Generation)

---

## 🧪 Automated Testing Suite

The codebase features a comprehensive automated unit testing framework powered by **JUnit 5 (Jupiter)**. The testing architecture systematically verifies pricing boundary limits and mutation integrity across all core domain objects:

- **`SandwichTest`**: Validates baseline matrix pricing across all standard lengths ($5.50 for 4", $7.00 for 8", $8.50 for 12") and checks item deletion mechanisms.
- **`DrinkTest`**: Verifies strict compliance for small ($2.00), medium ($2.50), and large ($3.00) drink iterations.
- **`ChipsTest`**: Confirms baseline pricing consistency ($1.55) across multiple flavor variants.

To execute the full testing matrix locally inside your terminal:
```bash
mvn test
```

---

## 📋 Menu Configurations Implemented
#### 1. Sandwiches (Base Pricing)
- 4-inch: $5.50 | Premium Meat: +$1.00 (Extra: +$0.50) | Premium Cheese: +$0.75 (Extra: +$0.30)
- 8-inch: $7.00 | Premium Meat: +$2.00 (Extra: +$1.00) | Premium Cheese: +$1.50 (Extra: +$0.60)
- 12-inch: $8.50 | Premium Meat: +$3.00 (Extra: +$1.50) | Premium Cheese: +$2.25 (Extra: +$0.90)

#### 2. Expanded Free Inclusions
- Regular Toppings: Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumbers, Pickles, Guacamole, Mushrooms
- Sauces: Mayo, Mustard, Ketchup, Ranch, Thousand Islands, Vinaigrette
- Sides: Au Jus, Sauce Cup

#### 3. Drinks & Chips
- Drinks: Small ($2.00), Medium ($2.50), Large ($3.00)
- Chips: Fixed baseline ($1.55) across Regular, BBQ, and Sour Cream variations.

---

## 🏃‍♂️ Getting Started

##### Prerequisites:
- Java Development Kit (JDK) 17 or higher
- Apache Maven or open-source web server (Optional, or utilize an IDE wrapper like IntelliJ IDEA)

#### Execution
- Clone this repository to your local computer environment.
- Open the project folder directly inside IntelliJ IDEA.
- Locate the file containing your application main entry point: `src/main/java/com/pluralsight/deli/Main.java`.
- Right-click and hit Run `Main.main()` to launch the console system.

---

```
src/main/java/com/pluralsight/deli
│
├── Main.java                 # Application entry point (Main.main())
│
├── data/
│   └── Receipt.java          # Handles file I/O and saving receipt text logs
│
├── model/
│   ├── Orderable.java        # Core interface defining pricing and details contracts
│   ├── Toppings.java         # Immutable Record tracking topping tags and custom math
│   ├── Sandwich.java         # Main sandwich object, premium upsells, and removal filtering
│   ├── Drink.java            # Model managing sizes, flavors, and pricing tiers
│   └── Chips.java            # Model managing chip types and baseline cost layers
│
└── ui/
└── UserInterface.java    # Interactive console input loops, menu paths, and editing flows
```

---

## 👤 Author: Shamar Grinley
Built & Developed Built as a Java capstone project to demonstrate:
- Project Role: Solo Backend & Architecture Developer
- Core Focus: Object-Oriented Design (`OOD`), Unit Testing (`JUnit 6`), Data Collection Formats
