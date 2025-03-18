package common;

import inventory.InventoryItem;
import staff.Staff;

import java.util.List;

public class TablePrinter {

    public static void printTable(InventoryItem[] items) {
        int idWidth = 5;
        int nameWidth = 15;
        int qtyWidth = 8;
        int priceWidth = 10;
        int unitWidth = 10;
        int dateWidth = 12;
        int totalWidth = idWidth + nameWidth + qtyWidth + priceWidth + unitWidth + dateWidth + 15;

        // Print header
        System.out.println("=".repeat(totalWidth));
        System.out.printf("| %-4s | %-14s | %7s | %9s | %-9s | %-11s |\n",
                "ID", "Name", "Qty", "Price", "Unit", "Expire Date");
        System.out.println("-".repeat(totalWidth));

        // Print each row
        for (InventoryItem item : items) {
            System.out.printf("| %-4d | %-14s | %7d | %9.2f | %-9s | %-11s |\n",
                    item.getId(), item.getName(), item.getQuantity(), item.getPrice(),
                    item.getUnit(), item.getExpireDate());
        }

        // Print footer
        System.out.println("=".repeat(totalWidth));
    }

    public static void printTable(Staff[] staffList){
        int idWidth = 5;
        int nameWidth = 15;
        int contactWidth = 15;
        int roleWidth = 15;
        int salaryWidth = 10;
        int positionWidth = 15;
        int totalWidth = idWidth + nameWidth + contactWidth + roleWidth + salaryWidth + positionWidth + 15;

        // Print header
        System.out.println("=".repeat(totalWidth));
        System.out.printf("| %-4s | %-14s | %14s | %14s | %9s | %-14s |\n",
                "ID", "Name", "Contact", "Role", "Salary", "Position");
        System.out.println("-".repeat(totalWidth));

        // Print each row
        for (Staff staff : staffList) {
            System.out.printf("| %-4d | %-14s | %14s | %14s | %9.2f | %-14s |\n",
                    staff.getId(), staff.getName(), staff.getContact(), staff.getRole(),
                    staff.getSalary(), staff.getPosition());
        }

        // Print footer
        System.out.println("=".repeat(totalWidth));
    }

}
