package models;

public class Scriptwriter {

    private int id;
    private String name;
    private String country;
    private String birthday;
    private String photo;

    public Scriptwriter(int id, String name, String country, String birthday, String photo) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoto() {
        return photo;
    }
}