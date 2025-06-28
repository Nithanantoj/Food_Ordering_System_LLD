

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("        🍽️  Welcome to Zomato  🍽️");
        System.out.println("=====================================\n");
        System.out.println("👉 Please select your role:");
        System.out.println("1. 🏪 Restaurant");
        System.out.println("2. 👤 Customer");
        System.out.println("3. ❌ Exit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        while(true) {
            if (choice == 1) {
                RestaurantPage.restaurant();
                return;
            } else if (choice == 2) {
                CustomerPage.customer();
                return;
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("❌ Invalid choice.");
            }
        }

    }
}