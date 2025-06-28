import controller.AuthController;
import services.RestaurantAuthServices;

import java.util.Scanner;

public class RestaurantPage {
    public static void restaurant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        🍽️  Welcome to Zomato  🍽️");
        System.out.println("=====================================\n");
        System.out.println("👉 Please select any one:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        AuthController authController = new RestaurantAuthServices();

        while (true){
            if(choice == 1){
                System.out.println("Enter Your Name :");
                String name = sc.nextLine();
                System.out.println("Enter Your Email ID:");
                String email = sc.nextLine();
                System.out.println("Enter Your Password:");
                String password = sc.nextLine();
                System.out.println("Enter Your Location:");
                String location = sc.nextLine();

                boolean success = authController.register(name, email, password, location);


                System.out.println(success ? "✅ Registered successfully!" : "❌ Username already exists.");
            }else if(choice == 2){
                System.out.println("Enter Your Email ID:");
                String email = sc.nextLine();
                System.out.println("Enter Your Password:");
                String password = sc.nextLine();

                String success = authController.login(email, password);

                System.out.println(success);
            } else if(choice == 3){
                return;
            }else if(choice == 4){
                RestaurantPage.restaurant();
            }else{
                System.out.println("❌ Invalid option.");
            }

            System.out.println("👉 Please select any one:");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("4. Logout");

            choice = sc.nextInt();
            sc.nextLine();
        }
    }
}
