package order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void createOrder(String customerName, List<OrderItem> items) {
        orders.add(new Order(customerName, items));
    }

    public void viewOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);
    }
}