package controller;

public interface AuthController {
    boolean register(String name, String Email, String Password, String Location);
    String login(String Email, String Password);
}
