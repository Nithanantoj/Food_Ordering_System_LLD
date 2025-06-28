package repository;

import entity.Restaurant;
import entity.User;

import java.util.HashMap;
import java.util.Map;

public class RestaurantStore {
    private Map<String, Restaurant> restuarants = new HashMap<>();

    public boolean addRestaurant(Restaurant restaurant){
        if(!restuarants.containsKey(restaurant.getEmail())){
            restuarants.put(restaurant.getEmail(),restaurant);
            return true;
        }

        return false;
    }

    public Restaurant getRestaurant(String Email){
        return restuarants.get(Email);
    }
}
