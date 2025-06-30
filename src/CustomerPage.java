import controller.AuthController;
import entity.MenuItem;
import entity.Order;
import entity.Restaurant;
import entity.User;
import repository.RestaurantStore;
import repository.UserStore;
import services.UserAuthServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerPage {
    static boolean isLogin = false;
    static boolean isRegister = false;
    public static void customer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        🍽️  Welcome to Zomato  🍽️");
        System.out.println("=====================================\n");


        AuthController authController = new UserAuthServices();
        UserStore userStore = new UserStore();

        while(true) {
            System.out.println("👉 Please select any one:");
            if(isRegister == false)
                System.out.println("1. Register");
            if(isLogin == false)
                System.out.println("2. Login");
            System.out.println("3. Exit");
            if(isLogin == true)
                System.out.println("4. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Your Name :");
                String name = sc.nextLine();
                System.out.println("Enter Your Email ID:");
                String email = sc.nextLine();
                System.out.println("Enter Your Password:");
                String password = sc.nextLine();
                System.out.println("Enter Your Location:");
                String location = sc.nextLine();

                boolean success = authController.register(name, email, password, location);


                if(success) {
                    System.out.println("✅ Registered successfully!");
                    isRegister = true;
                }else {
                    System.out.println("❌ Username already exists.");
                }
            }else if(choice == 2) {
                System.out.println("Enter Your Email ID:");
                String email = sc.nextLine();
                System.out.println("Enter Your Password:");
                String password = sc.nextLine();

                String success = authController.login(email, password);

                System.out.println(success);

                if(success.equals("✅ Login successful.")) {
                    isLogin = true;
                    User r = userStore.getUser(email);  // ✅ should not be null now
                    showCustomerDashboard(r);
                }

            }else if(choice == 3){
                break;
            }
            else if(choice == 4){
                CustomerPage.customer();
            }else{
                System.out.println("❌ Invalid option.");
            }

        }
    }

    public static void showCustomerDashboard(User customer) {
        Scanner sc = new Scanner(System.in);
        RestaurantStore restaurantStore = new RestaurantStore();

        while (true) {
            System.out.println("\n========== 👤 Customer Dashboard ==========");
            System.out.println("1. View All Restaurants");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View My Orders");
            System.out.println("5. Logout\n");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("🏪 Available Restaurants:");
                List<Restaurant> restaurants = restaurantStore.getAllRestaurants();
                for (Restaurant r : restaurants) {
                    System.out.println("🍽️ " + r.getId() +" " +r.getName() + " (Email: " + r.getUsername() + ")");
                }
            }
            else if (choice == 2) {
                System.out.print("Enter restaurant email to view menu: ");
                int id = Integer.parseInt(sc.nextLine());
                Restaurant r = restaurantStore.getRestaurantById(id);
                if (r != null) {
                    System.out.println("📋 Menu of " + r.getName() + ":");
                    for (MenuItem item : r.getMenuItems()) {
                        System.out.println("🆔 " + item.getId() + " | " + item.getName() + " - ₹" + item.getPrice());
                    }
                } else {
                    System.out.println("❌ Restaurant not found.");
                }
            }
            else if (choice == 3) {
                System.out.print("Enter restaurant id to order from: ");
                int id = Integer.parseInt(sc.nextLine());
                Restaurant r = restaurantStore.getRestaurantById(id);
                if (r != null) {
                    List<MenuItem> items = r.getMenuItems();
                    if (items.isEmpty()) {
                        System.out.println("❌ No items available.");
                        continue;
                    }

                    List<MenuItem> orderItems = new ArrayList<>();
                    while (true) {
                        System.out.println("Menu:");
                        for (MenuItem item : items) {
                            System.out.println("🆔 " + item.getId() + " | " + item.getName() + " - ₹" + item.getPrice());
                        }

                        System.out.print("Enter item ID to add to order (or 0 to finish): ");
                        int MenuId = sc.nextInt(); sc.nextLine();
                        if (MenuId == 0) break;

                        for (MenuItem item : items) {
                            if (item.getId() == MenuId) {
                                orderItems.add(item);
                                System.out.println("✅ Added to order.");
                                break;
                            }
                        }
                    }

                    if (!orderItems.isEmpty()) {
                        Order order = new Order(orderItems, r.getUsername());
                        customer.addOrder(order);
                        r.receiveOrder(order);
                        restaurantStore.update(r);
                        System.out.println("✅ Order placed!");
                    } else {
                        System.out.println("❌ No items selected.");
                    }
                } else {
                    System.out.println("❌ Restaurant not found.");
                }
            }
            else if (choice == 4) {
                System.out.println("📦 Your Orders:");
                for (Order o : customer.getOrders()) {
                    System.out.println(o);
                }
            }
            else if (choice == 5) {
                System.out.println("👋 Logged out.");
                break;
            }
            else {
                System.out.println("❌ Invalid option.");
            }
        }
    }

}
