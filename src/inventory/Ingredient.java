package inventory;

public abstract class Ingredient {
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void setExpirationDate();

    @Override
    public String toString() {
        return "Ingredient: " + name;
    }
}
