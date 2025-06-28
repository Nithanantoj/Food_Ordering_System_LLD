package entity;

import java.util.List;

public class Order {
    private static int counter = 1;
    private int id;
    private List<MenuItem> items;
    private String customerName;
    private double totalAmount;
    private String status; // e.g., Pending, Accepted, Delivered

    public Order(List<MenuItem> items, String customerName) {
        this.id = counter++;
        this.items = items;
        this.customerName = customerName;
        this.totalAmount = items.stream().mapToDouble(MenuItem::getPrice).sum();
        this.status = "Pending";
    }

    public int getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Customer: " + customerName +
                ", Total: ₹" + totalAmount + ", Status: " + status;
    }
}
