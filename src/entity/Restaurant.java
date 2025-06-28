package entity;

import java.util.*;

public class Restaurant {
    private String Email;
    private String password;
    private String name;
    private String Location;
    private List<MenuItem> menuItems;
    private List<Order> orders;

    public Restaurant(String Email, String password, String name, String Location) {
        this.Email = Email;
        this.password = password;
        this.name = name;
        this.Location = Location;
        this.menuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Getters
    public String getEmail() { return Email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public List<MenuItem> getMenuItems() { return menuItems; }
    public List<Order> getOrders() { return orders; }

    // Menu Functionalities
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeMenuItem(int id) {
        menuItems.removeIf(item -> item.getId() == id);
    }

    public void updateMenuItem(int id, String newName, double newPrice) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                item.setName(newName);
                item.setPrice(newPrice);
            }
        }
    }

    // Order Functionalities
    public void receiveOrder(Order order) {
        orders.add(order);
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                order.setStatus(status);
            }
        }
    }

    public void viewAllOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
