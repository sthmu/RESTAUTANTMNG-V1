package inventory;

public class InventoryItem extends Ingredient {
    private int quantity;
    private double price;

    public InventoryItem(String name, int quantity, double price) {
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quantity: " + quantity + ", Price: " + price;
    }
}