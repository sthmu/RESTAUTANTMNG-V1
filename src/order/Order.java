package order;

import java.util.List;

public class Order {
    private static int idCounter = 0;
    private int id;
    private String customerName;
    private List<OrderItem> items;

    public Order(String customerName, List<OrderItem> items) {
        this.id = ++idCounter;
        this.customerName = customerName;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "order.Order ID: " + id + ", Customer: " + customerName + ", Items: " + items;
    }
}