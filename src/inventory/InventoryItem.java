package inventory;

import java.time.LocalDate;

public class InventoryItem  {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Unit unit; // Unit of measurement
    private LocalDate expireDate;

    public InventoryItem(int id, String name, int quantity, double price,Unit unit, LocalDate expireDate) {
        this.id=id;
        this.name=name;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
        this.expireDate = expireDate;
    }

    public InventoryItem(String name, int quantity, double price, LocalDate expireDate) {
        this.name=name;
        this.quantity = quantity;
        this.price = price;
        this.unit = Unit.PIECES;
        this.expireDate = expireDate;
    }
    public InventoryItem(String name, int quantity, double price,Unit unit, LocalDate expireDate) {
        this.name=name;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
        this.expireDate = expireDate;
    }


    public InventoryItem(String itemName) {
        this.name = itemName;
    }
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //add quantity methods and substract
    public void addQuantity(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot add a negative amount.");
        }
        this.quantity += amount;
    }

    // Subtract quantity (e.g., usage in recipes)
    public void subtractQuantity(double amount) {
        if (amount < 0 || amount > this.quantity) {
            throw new IllegalArgumentException("Invalid subtraction amount.");
        }
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "InventoryItem [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", unit=" + unit + ", expireDate=" + expireDate + "]";
    }
}