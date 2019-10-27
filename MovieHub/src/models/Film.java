package models;

public class Film {

    private int id;
    private String name;
    private String country;
    private String date;
    private int likes;
    private int dislikes;
    private String photo;
    private String text;

    public Film(int id, String name, String country, String date, int likes, int dislikes, String photo, String text) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public String getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }
}
