package entity;

public class MenuItem {
    private static int counter = 1;
    private int id;
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return id + ". " + name + " - ₹" + price;
    }
}

