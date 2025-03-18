import common.ManagerClass;
import common.TitleStrings;
import inventory.InventoryItem;
import inventory.InventoryManager;
import menu.MenuManager;
import order.OrderItem;
import order.OrderManager;
import order.OrderStatus;
import staff.StaffManager;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RestaurantManagementSystem extends ManagerClass {
    private InventoryManager inventoryManager = new InventoryManager();
    private OrderManager orderManager = new OrderManager();
    private StaffManager staffManager = new StaffManager();
    private MenuManager menuManager = new MenuManager();

    public void manageInventory() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println(TitleStrings.MANAGE_INVENTORY);
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Items");
            System.out.println("4. View Notifications");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter expire date (YYYY-MM-DD): ");
                    String expireDateString = scanner.next();
                    LocalDate expireDate = LocalDate.parse(expireDateString);
                    inventoryManager.add(name, quantity, price, expireDate);
                    break;
                case 2:
                    inventoryManager.view();
                    System.out.print("Enter item name to remove: ");
                    String itemName = scanner.nextLine();
                    inventoryManager.remove(new InventoryItem(itemName));
                    break;
                case 3:
                    inventoryManager.view();
                    break;
                case 4:
                    inventoryManager.viewNotifications();
                    break;
                case 5:
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void manageOrders() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println(TitleStrings.ORDER_MANAGE);
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. Remove Order");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    orderManager.viewOrders();
                    break;
                case 3:
                    System.out.print("Enter order ID to update: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status (PENDING, PROCESSING, COMPLETED, CANCELLED): ");
                    String statusString = scanner.next();
                    OrderStatus status = OrderStatus.valueOf(statusString.toUpperCase());
                    orderManager.updateOrderStatus(orderId, status);
                    break;
                case 4:
                    System.out.print("Enter order ID to remove: ");
                    int removeOrderId = scanner.nextInt();
                    orderManager.removeOrder(removeOrderId);
                    break;
                case 5:
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        List<OrderItem> items = new ArrayList<>();
        while (true) {
            clearConsole();
            System.out.print("Enter item name (or enter 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            items.add(new OrderItem(itemName, quantity, price));
        }

        orderManager.createOrder(customerName, items);
        System.out.println("Order placed successfully!");
    }

    public void manageEmployees() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println(TitleStrings.MANAGE_STAFF);
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = getValidInt(scanner); // Using helper method to get valid integer input

            switch (choice) {
                case 1:
                    int id = getValidInt(scanner, "Enter employee ID: ");
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    double salary = getValidDouble(scanner, "Enter salary: ");
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    staffManager.addStaff(id, name, contact, role, salary, position);
                    break;
                case 2:
                    System.out.print("Enter employee name to remove: ");
                    String employeeName = scanner.nextLine();
                    staffManager.removeEmployee(employeeName);
                    break;
                case 3:
                    staffManager.viewStaff();
                    break;
                case 4:
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Helper method to ensure valid integer input
     */
    private int getValidInt(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Overloaded helper method with a custom message
     */
    private int getValidInt(Scanner scanner, String message) {
        System.out.print(message);
        return getValidInt(scanner);
    }

    /**
     * Helper method to ensure valid double input
     */
    private double getValidDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public void manageMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearConsole();
            System.out.println(TitleStrings.MANAGE_MENU);
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. View Menu Items");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter menu item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    List<String> array2= List.of(new String[]{"dehi", "sugar", "water"});
                    menuManager.addMenuItem(name, price,true,array2);
                    break;
                case 2:
                    System.out.print("Enter menu item name to remove: ");
                    String itemName = scanner.nextLine();
                    menuManager.removeMenuItem(itemName);
                    break;
                case 3:
                    menuManager.viewMenuItems();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. try again.");
            }
        }
    }
}