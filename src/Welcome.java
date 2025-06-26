import controller.AuthController;
import services.UserAuthServices;

import java.util.Scanner;

public class Welcome {
    public static void welocme(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*****Welcome To Zomato*****");
        System.out.println("");
        System.out.println("---Choose any 1---");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        AuthController authController = new UserAuthServices();

        while(true) {

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


                System.out.println(success ? "✅ Registered successfully!" : "❌ Username already exists.");
            }else if(choice == 2) {
                System.out.println("Enter Your Email ID:");
                String email = sc.nextLine();
                System.out.println("Enter Your Password:");
                String password = sc.nextLine();

                String success = authController.login(email, password);

                System.out.println(success);

            }else if(choice == 3){
                break;
            }
            else if(choice == 4){
                Welcome.welocme();
            }

            System.out.println("---Choose any 1---");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("4. Logout");

            choice = sc.nextInt();
            sc.nextLine();
        }
    }
}
