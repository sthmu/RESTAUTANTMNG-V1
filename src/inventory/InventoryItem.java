package inventory;

import java.time.LocalDate;

public class InventoryItem extends Ingredient {
    private int quantity;
    private double price;
    private String type;
     private LocalDate expirationDate;
    private LocalDate addedDate = LocalDate.now();

    public InventoryItem(String name,String type, int quantity, double price) {
        super(name);
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.setExpirationDate();
    }

    @Override
    protected void setExpirationDate() {
    String normalizedType = this.type.toLowerCase().trim();

    int expirationDays = switch(normalizedType) {
        // DAIRY & EGGS
        case "milk", "fresh milk" -> 7;
        case "yogurt" -> 14;
        case "butter" -> 30;
        case "cheese", "hard cheese" -> 21;
        case "soft cheese", "cream cheese" -> 10;
        case "eggs" -> 28;
        case "ice cream" -> 60;

        // MEAT & POULTRY
        case "beef", "steak" -> 5;
        case "ground beef" -> 3;
        case "pork" -> 5;
        case "chicken" -> 3;
        case "turkey" -> 3;
        case "bacon" -> 7;
        case "sausage" -> 3;
        case "deli meats" -> 5;

        // SEAFOOD
        case "fresh fish" -> 2;
        case "salmon" -> 2;
        case "shrimp" -> 2;
        case "crab" -> 2;
        case "lobster" -> 2;
        case "sushi" -> 1;
        case "canned tuna" -> 365;

        // VEGETABLES
        case "lettuce" -> 5;
        case "spinach" -> 4;
        case "carrots" -> 14;
        case "broccoli" -> 7;
        case "potatoes" -> 30;
        case "tomatoes" -> 7;
        case "onions" -> 30;
        case "bell peppers" -> 7;

        // FRUITS
        case "apples" -> 30;
        case "bananas" -> 5;
        case "oranges" -> 14;
        case "grapes" -> 7;
        case "berries" -> 3;
        case "melon" -> 5;
        case "pineapple" -> 5;

        // BAKED GOODS
        case "bread" -> 7;
        case "bagels" -> 5;
        case "croissants" -> 3;
        case "cake" -> 5;
        case "cookies" -> 14;

        // PANTRY ITEMS
        case "rice" -> 180;
        case "pasta" -> 365;
        case "flour" -> 180;
        case "cereal" -> 90;
        case "canned soup" -> 365;
        case "peanut butter" -> 90;
        case "jam" -> 180;
        case "honey" -> 999; // Doesn't expire

        // BEVERAGES
        case "soda" -> 180;
        case "juice" -> 14;
        case "beer" -> 180;
        case "wine" -> 365;
        case "milk carton" -> 90;

        // FROZEN FOODS
        case "frozen vegetables" -> 180;
        case "frozen pizza" -> 90;
        case "ice cubes" -> 365;
        case "frozen berries" -> 180;

        // CONDIMENTS
        case "ketchup" -> 180;
        case "mustard" -> 365;
        case "mayonnaise" -> 60;
        case "soy sauce" -> 365;

        // SNACKS
        case "chips" -> 30;
        case "crackers" -> 90;
        case "nuts" -> 60;
        case "chocolate" -> 180;

        // SPECIAL DIETARY
        case "baby food" -> 30;
        case "protein powder" -> 180;
        case "meal replacement" -> 90;

        // DEFAULT
        default -> {
            if (normalizedType.contains("canned")) yield 365;
            if (normalizedType.contains("frozen")) yield 180;
            if (normalizedType.contains("dried")) yield 365;
            yield 14; // General default
        }
    };

    expirationDate = addedDate.plusDays(expirationDays);
}


    public LocalDate getAddedDate() {
        return addedDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
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
                "addedDate=" + addedDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", expirationDate=" + expirationDate +
                "} " + super.toString();
    }
}