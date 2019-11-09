package models;

public class Film {

    private int id;
    private String name;
    private String country;
    private String date;
    private String photo;
    private String text;

    public Film(int id, String name, String country, String date, String photo, String text) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.date = date;
        this.photo = photo;
        this.text = text;
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

    public String getDate() {
        return date;
    }

    public String getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }
}
