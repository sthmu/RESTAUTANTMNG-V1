package inventory;

import Notifications.Notification;
import common.ManagerClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager extends ManagerClass {
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

    public void add(String name, int quantity, double price, LocalDate expireDate) {
        InventoryItem item = new InventoryItem(name, quantity, price, expireDate);
        items.add(item);
        checkNotifications(item);
    }
    public void add(InventoryItem item) {
        items.add((InventoryItem) item);
        checkNotifications((InventoryItem) item);
    }

    public void remove(int id) {
        items.removeIf(item -> item.getId()==(id));
    }
    public void remove(String name) {
        items.removeIf(item -> ((InventoryItem)item).getName().equals(name));
    }
    public void remove(InventoryItem item) {
        if(item.getId()!=0){
            remove(item.getId());
        }else if (item.getName()!=null) {
            remove(item.getName());
        }else{
            System.out.println("Invalid item");
            return;
        }

    }

    public void view() {
        for (InventoryItem item : items) {
            System.out.println(item);
        }
    }

    public void viewNotifications() {
        //this will set the notifications array
        for (InventoryItem item: items) {
            checkNotifications((InventoryItem) item);
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

    public List<InventoryItem> getItems() {
        return items;
    }
}