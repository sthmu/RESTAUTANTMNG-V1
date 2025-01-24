package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItems;

    public MenuManager() {
        menuItems = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        menuItems.add(new MenuItem(name, price));
    }

    public void removeMenuItem(String name) {
        menuItems.removeIf(item -> item.getName().equals(name));
    }

    public void viewMenuItems() {
        for (MenuItem item : menuItems) {
            System.out.println(item);
        }
    }
}