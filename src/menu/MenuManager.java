package menu;

import java.util.ArrayList;
import java.util.List;
// Class to manage the menu
public class MenuManager {
    // List of menu items
    private List<MenuItem> menuItems;
    // Constructor to initialize the menu management system
    public MenuManager() {
        this.menuItems = new ArrayList<>();
    }
    // Method to add a new menu item
    public void addMenuItem(String name, double price,boolean isAvailable) {
        menuItems.add(new MenuItem(name, price, isAvailable));
    }
    // Method to remove a menu item
    public void removeMenuItem(String name) {
        menuItems.removeIf(item -> item.getName().equals(name));
        System.out.println("Menu item removed successfully!");
    }
    // Method to check the availability of a menu item
    public void checkAvailability(String name) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) { // Find the menu item by name
                System.out.println("Availability of " + name + ": " + (menuItem.getisAvailable() ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Menu item not found!"); // Error message if item is not found
    }
    // Method to display all menu items
    public void viewMenuItems() {
        for (MenuItem item : menuItems) {
            System.out.println(item);
        }
    }
}