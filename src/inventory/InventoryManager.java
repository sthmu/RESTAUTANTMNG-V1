package inventory;

import Notifications.Notification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<InventoryItem> items;
    private List<Notification> notifications;
    private static InventoryDatabaseManager inventoryDatabaseManager;

    public InventoryManager() {
        items = new ArrayList<>();
        notifications = new ArrayList<>();
        inventoryDatabaseManager = new InventoryDatabaseManager();
        inventoryDatabaseManager.createInventoryItemTable();

//        settin the itemlist
        items = inventoryDatabaseManager.viewItems();

    }

    public void addItem(String name, int quantity, double price, LocalDate expireDate) {
        InventoryItem item = new InventoryItem(name, quantity, price, expireDate);
        items.add(item);
        checkNotifications(item);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public void viewItems() {
        for (InventoryItem item : items) {
            System.out.println(item);
        }
    }

    public void viewNotifications() {
        //this will set the notifications array
        for (InventoryItem item: items) {
            checkNotifications(item);
        }
        for (Notification notification : notifications) {
            System.out.println(notification.getNoticationMessage());
        }
    }

    private void checkNotifications(InventoryItem item) {
        LocalDate today = LocalDate.now();
        if (item.getExpireDate().isBefore(today.plusDays(2))) {
            Notification notification = new Notification();
            notification.setNotificationId("1");
            notification.setNoticationMessage("Item " + item.getName() + " is expiring soon.");
            notifications.add(notification);
        }
        if (item.getQuantity() < 5) { // Assuming 5 as the low stock threshold
            Notification notification = new Notification();
            notification.setNotificationId("2");
            notification.setNoticationMessage("Item " + item.getName() + " is low in stock.");
            notifications.add(notification);
        }
    }

}