package entity;

public class User {
    private String name;
    private String Email;
    private String Password;
    private String Location;

    public User(String name, String Email, String Password, String Location){
        this.name = name;
        this.Email = Email;
        this.Password = Password;
        this.Location = Location;
    }

    public String getEmail(){
        return Email;
    }

    public String getPassword(){
        return Password;
    }
}
