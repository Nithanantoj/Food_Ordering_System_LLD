import controller.AuthController;
import entity.MenuItem;
import entity.Restaurant;
import repository.RestaurantStore;
import services.RestaurantAuthServices;

import java.util.Scanner;

public class RestaurantPage {
    public static void restaurant(){
        Scanner sc = new Scanner(System.in);
        AuthController authController = new RestaurantAuthServices();
        RestaurantStore restaurantStore = new RestaurantStore();
        System.out.println("=====================================");
        System.out.println("        🍽️  Welcome to Zomato  🍽️");
        System.out.println("=====================================\n");

        boolean isRegister = false;
        boolean isLogin = false;

        while (true){


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



            switch (choice) {
                case 1 : {
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

                    break;
                }
                case 2 : {
                    System.out.println("Enter Your Email ID:");
                    String email = sc.nextLine();
                    System.out.println("Enter Your Password:");
                    String password = sc.nextLine();

                    String success = authController.login(email, password);

                    System.out.println(success);

                    if(success.equals("✅ Login successful.")) {
                        isLogin = true;
                        Restaurant r = restaurantStore.getRestaurant(email);  // ✅ should not be null now
                        showRestaurantDashboard(r);
                    }

                    break;
                }
                case 3 :
                    System.out.println("👋 Thank you for using Zomato. Goodbye!");
                    return;
                case 4 : {
                    System.out.println("👋 Logged out successfully.");
                    isLogin = false;
                    isRegister = false;
                    break;
                }
                default:
                    System.out.println("❌ Invalid option.");

            }

        }
    }

    public static void showRestaurantDashboard(Restaurant restaurant) {
        Scanner sc = new Scanner(System.in);
        RestaurantStore restaurantStore = new RestaurantStore();


        while (true){
            System.out.println("\n========== 🍽️ Restaurant Dashboard ==========");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Update Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. View Menu");
            System.out.println("5. Logout\n");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                MenuItem item = new MenuItem(name, price);
                restaurant.addMenuItem(item);
                restaurantStore.update(restaurant);
                System.out.println("✅ Menu item added.");
            }
            else if(option == 2){
                System.out.print("Enter item ID to update: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = sc.nextDouble(); sc.nextLine();

                restaurant.updateMenuItem(id, newName, newPrice);
                restaurantStore.update(restaurant);
                System.out.println("✅ Item updated.");
            }
        }
    }
}
