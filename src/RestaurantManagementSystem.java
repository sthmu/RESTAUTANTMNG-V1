import inventory.Inventory;
import menu.MenuManager;
import order.OrderItem;
import order.OrderManager;
import staff.StaffManager;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RestaurantManagementSystem {
    private Inventory inventory = new Inventory();
    private OrderManager orderManager = new OrderManager();
    private StaffManager staffManager = new StaffManager();
    private MenuManager menuManager = new MenuManager();

    public void manageInventory() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Items");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    inventory.addItem(name, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemName = scanner.nextLine();
                    inventory.removeItem(itemName);
                    break;
                case 3:
                    inventory.viewItems();
                    break;
                case 4:
                    return;
                default:
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
            System.out.print("Enter item name (or 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            items.add(new OrderItem(itemName, quantity));
        }

        orderManager.createOrder(customerName, items);
        System.out.println("Order placed successfully!");
    }

    public void manageEmployees() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
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
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void manageMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. View Menu Items");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter menu item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    List<String> array2= List.of(new String[]{"chocolate", "sugar", "water"});
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
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}