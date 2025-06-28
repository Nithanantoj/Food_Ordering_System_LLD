package services;

import controller.AuthController;
import entity.Restaurant;
import repository.RestaurantStore;

public class RestaurantAuthServices implements AuthController {

    RestaurantStore restaurantStore = new RestaurantStore();

    @Override
    public boolean register(String name, String Email, String Password, String Location) {
        Restaurant restaurant = new Restaurant(Email, Password, name, Location);
        return restaurantStore.addRestaurant(restaurant);
    }

    @Override
    public String login(String Email, String Password) {
        Restaurant restaurant = restaurantStore.getRestaurant(Email);

        if(restaurant != null){
            if(restaurant.getPassword().equals(Password)){
                return "✅ Login successful.";
            }
            else{
                return "❌ Invalid username or password.";
            }
        }else{
            return "❌ Restaurant is Not Found";
        }
    }
}
