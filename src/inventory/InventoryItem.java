package inventory;

import java.time.LocalDate;

public class InventoryItem extends Ingredient {
    private int quantity;
    private double price;
    private LocalDate expireDate;

    public InventoryItem(String name, int quantity, double price, LocalDate expireDate) {
        super(name);
        this.quantity = quantity;
        this.price = price;
        this.expireDate = expireDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quantity: " + quantity + ", Price: " + price + ", Expire Date: " + expireDate;
    }
}