import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManagementSystem system = new RestaurantManagementSystem();

        while (true) {
            System.out.println("1. Manage Inventory");
            System.out.println("2. Place order");
            System.out.println("3. Manage Employees");
            System.out.println("4. Manage Menu");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.manageInventory();
                    break;
                case 2:
                    system.placeOrder();
                    break;
                case 3:
                    system.manageEmployees();
                    break;
                case 4:
                    system.manageMenu();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}