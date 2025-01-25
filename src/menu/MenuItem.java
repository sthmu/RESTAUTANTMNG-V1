package menu;
// Class to represent a menu item
public class MenuItem {
    private String name;// Name of the menu item
    private double price;// Price of the menu item
    private boolean isAvailable; // Availability status of the menu item

    public MenuItem(String name, double price,boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getisAvailable() {return isAvailable; }

    // Method to set the availability status of the menu item
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "menu.MenuItem: " + name + ", Price: " + price + ",Availability: "+ (isAvailable ? "Yes" : "No");
    }
}