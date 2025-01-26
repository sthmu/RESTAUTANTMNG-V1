import common.TitleStrings;

import java.util.Scanner;

import static common.ManagerClass.clearConsole;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManagementSystem system = new RestaurantManagementSystem();

        while (true) {
            clearConsole();
            System.out.println(TitleStrings.APP_TITLE);
            System.out.println("1. Manage Inventory");
            System.out.println("2. Place order");
            System.out.println("3. Manage Employees");
            System.out.println("4. Manage Menu");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clearConsole();
                    system.manageInventory();
                    break;
                case 2:
                    clearConsole();
                    system.placeOrder();
                    break;
                case 3:
                    clearConsole();
                    system.manageEmployees();
                    break;
                case 4:
                    clearConsole();
                    system.manageMenu();
                    break;
                case 5:
                    clearConsole();
                    System.out.println("Exiting...");
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}