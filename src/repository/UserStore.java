package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static Map<String, User> users = new HashMap<>();

    public boolean addUser(User user){
        if(!users.containsKey(user.getEmail())){
            users.put(user.getEmail(),user);
            return true;
        }

        return false;
    }

    public User getUser(String Email){
        return users.get(Email);
    }

}
