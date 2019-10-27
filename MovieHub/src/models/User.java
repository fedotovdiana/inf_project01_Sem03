package models;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private String photo;

    public User(int id, String name, String login, String password, String photo) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }
}
