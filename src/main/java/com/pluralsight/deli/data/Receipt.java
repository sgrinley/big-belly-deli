
package com.pluralsight.deli.data;

import com.pluralsight.deli.model.Orderable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {

    public static void saveReceipt(List<Orderable> items, double total) {
        // Automatically ensure the directory path exists on disk
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Establish the naming convention pattern matching standard requirements
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + format.format(new Date()) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("========================================\n");
            writer.write("          Big Belly Deli         \n");
            writer.write("========================================\n\n");

            for (Orderable item : items) {
                writer.write(item.getDetails() + "\n");
                writer.write(String.format("    Price: $%.2f\n\n", item.getPrice()));
            }

            writer.write("----------------------------------------\n");
            writer.write(String.format("GRAND TOTAL AMOUNT: $%.2f\n", total));
            writer.write("========================================\n");
            System.out.println("Receipt successfully saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}

