package models;

public class Checklist {

    private int id_checklist;
    private String name;
    private int id_user;

    public Checklist(int id_checklist, String name, int id_user) {
        this.id_checklist = id_checklist;
        this.name = name;
        this.id_user = id_user;
    }

    public int getId_checklist() {
        return id_checklist;
    }

    public String getName() {
        return name;
    }

    public int getId_user() {
        return id_user;
    }
}
