package inventory;

import menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

public class Ingredient extends InventoryItem{
    private List<MenuItem>  associatedMenuItems;

    public Ingredient(String name, int quantity, double price, LocalDate expireDate) {
        super(name, quantity, price, expireDate);
    }

    public void setAssociatedMenuItems(List<MenuItem> associatedMenuItems) {
        this.associatedMenuItems = associatedMenuItems;
    }

    public List<MenuItem> getAssociatedMenuItems() {
        return associatedMenuItems;
    }

    @Override
    public String toString() {
        return super.toString() + ", associatedMenuItems=" + associatedMenuItems + "]";
    }
}
