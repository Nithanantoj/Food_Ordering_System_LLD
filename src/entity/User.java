package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String Email;
    private String Password;
    private String Location;

    private List<Order> orders;

    public User(String name, String Email, String Password, String Location){
        this.name = name;
        this.Email = Email;
        this.Password = Password;
        this.Location = Location;
        this.orders = new ArrayList<>();
    }

    public String getEmail(){
        return Email;
    }

    public String getPassword(){
        return Password;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
