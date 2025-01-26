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

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "order.Order ID: " + id + ", Customer: " + customerName + ", Items: " + items;
    }
}