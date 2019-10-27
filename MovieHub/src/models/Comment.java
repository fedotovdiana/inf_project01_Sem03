package models;

public class Comment {

    private int id_comment;
    private int id_user;
    private String title;
    private String text;
    private String date;

    public Comment(int id_comment, int id_user, String title, String text, String date) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public int getId_comment() {
        return id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}
