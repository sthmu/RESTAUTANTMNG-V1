package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryItem> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String name, int quantity, double price) {
        items.add(new InventoryItem(name, quantity, price));
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public void viewItems() {
        for (InventoryItem item : items) {
            System.out.println(item);
        }
    }
}