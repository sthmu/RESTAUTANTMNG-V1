package inventory;

public class InventoryItem extends Ingredient {
    private int quantity;
    private double price;
    private String type;

    public InventoryItem(String name,String type, int quantity, double price) {
        super(name);
        this.type = type;
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
        return "InventoryItem{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}