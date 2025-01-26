package order;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private static int idCounter = 0;
    private int id;
    private String customerName;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime orderTime;
    private LocalDateTime completionTime;

    public Order(String customerName, List<OrderItem> items) {
        this.id = ++idCounter;
        this.customerName = customerName;
        this.items = items;
        this.status = OrderStatus.PENDING;
        this.orderTime = LocalDateTime.now();
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        if (status == OrderStatus.COMPLETED) {
            this.completionTime = LocalDateTime.now();
        }
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Customer: " + customerName + ", Items: " + items + ", Status: " + status + ", Order Time: " + orderTime + ", Total: " + calculateTotal();
    }
}