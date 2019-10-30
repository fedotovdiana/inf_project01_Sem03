package models;

public class Comment {

    private int comment_id;
    private String user;
    private String title;
    private String text;
    private String date;
    private int film_id;

    public Comment(int comment_id, String user, String title, String text, String date, int film_id) {
        this.comment_id = comment_id;
        this.user = user;
        this.title = title;
        this.text = text;
        this.date = date;
        this.film_id = film_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user_id) {
        this.user = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
