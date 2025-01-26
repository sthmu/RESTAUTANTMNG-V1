package menu;

import java.util.List;

// Class to represent a menu item
public class MenuItem {
    //"private" Access modifier is used for Encapsulation
    private String name;// Name of the menu item
    private double price;// Price of the menu item
    private boolean isAvailable; // Availability status of the menu item
    private List<String> ingredients;  // List of ingredients for the menu item



    public MenuItem(String name, double price,boolean isAvailable,List<String> ingredients) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.ingredients = ingredients;
    }
    //Encapsulation-get()-return the value,set() methods-update the value

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

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String displayDetails() {
       return "menu.MenuItem: " + name + ", Price: " + price + ",Availability: "+ (isAvailable ? "Yes" : "No"+ ", Ingredients: " + ingredients);
    }
    //Inheritance
    class Drinks extends MenuItem {
        private String size;

        public Drinks(String name, double price, boolean isAvailable,String size) {
            super(name, price, isAvailable,ingredients);
            this.size = size;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        // Override the displayDetails method to include size-polymorphism
        @Override
        public String displayDetails() {
            return "menu.MenuItem: " + getName() + ", Price: " + getPrice() + ",Availability: "+ (getisAvailable() ? "Yes" : "No"+ ", Ingredients: " + ingredients+",Size: "+size);
        }
        //Inheritance
        class mainCourses extends MenuItem{
            private String cuisineType; // Type of cuisine (e.g., Italian, Indian)
            private String dietaryCategory;//vegetarian/vegan

            public String getCuisineType() {
                return cuisineType;
            }

            public void setCuisineType(String cuisineType) {
                this.cuisineType = cuisineType;
            }

            public String getDietaryCategory() {
                return dietaryCategory;
            }

            public void setDietaryCategory(String dietaryCategory) {
                this.dietaryCategory = dietaryCategory;
            }

            public mainCourses(String name, double price, boolean isAvailable, String cuisineType, String dietaryCategory) {
                super(name, price, isAvailable,ingredients);
                this.cuisineType=cuisineType;
                this.dietaryCategory=dietaryCategory;

            }
            @Override
            public String displayDetails() {
                return "menu.MenuItem: " + getName() + ", Price: " + getPrice() + ",Availability: "+ (getisAvailable() ? "Yes" : "No"+ ", Ingredients: " + ingredients+ "Cuisine Type: "+ cuisineType +"Dietary Category: "+dietaryCategory );
        }

}
           //Inheritance
          class Desserts extends MenuItem{
            private String temperature;
              public Desserts(String name, double price, boolean isAvailable,String temperature) {
                  super(name, price, isAvailable,ingredients);
                  this.temperature=temperature;
              }

              public String getTemperature() {
                  return temperature;
              }

              public void setTemperature(String temperature) {
                  this.temperature = temperature;
              }

              @Override
              public String displayDetails() {
                     return "menu.MenuItem: " + name + ", Price: " + price + ",Availability: "+ (isAvailable ? "Yes" : "No" + ", Ingredients: " + ingredients+ "Temperature: "+temperature );
          }
              }
          }
    }
