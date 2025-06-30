package repository;

import entity.Restaurant;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantStore {
    private static Map<String, Restaurant> restuarants = new HashMap<>();
      private static Map<Integer, Restaurant> restuarants2 = new HashMap<>();

    public boolean addRestaurant(Restaurant restaurant){
        if(!restuarants.containsKey(restaurant.getEmail())){
            restuarants.put(restaurant.getEmail(),restaurant);
            restuarants2.put(restaurant.getId(),restaurant);
            return true;
        }

        return false;
    }

    public Restaurant getRestaurant(String Email){
        return restuarants.get(Email);
    }

    public Restaurant getRestaurantById(int id){
        return restuarants2.get(id);
    }

    public void update(Restaurant restaurant) {
        restuarants.put(restaurant.getEmail(),restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restuarants.values());
    }
}
