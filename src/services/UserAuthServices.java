package services;

import controller.AuthController;
import entity.User;
import repository.UserStore;

public class UserAuthServices implements AuthController {

    UserStore userStore = new UserStore();
    @Override
    public boolean register(String name, String Email, String Password, String Location) {
        User user = new User(name, Email, Password, Location);
        return userStore.addUser(user);
    }

    @Override
    public String login(String Email, String Password) {
        User user = userStore.getUser(Email);
        if(user != null){
            if(user.getPassword().equals(Password)){
                return "✅ Login successful.";
            }
            else{
                return "❌ Invalid username or password.";
            }
        }else {
            return "❌ User Not Found";
        }
    }


}
