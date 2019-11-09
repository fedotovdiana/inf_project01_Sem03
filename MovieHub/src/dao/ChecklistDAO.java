package dao;

import helpers.ConnectHelper;
import models.Checklist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChecklistDAO implements DAO<Checklist> {

    //language=SQL
    private String SQL_INSERT = "INSERT INTO checklists (name, user_id) VALUES (?, ?)";
    private String SQL_DELETE_FILM ="DELETE FROM checklist_film WHERE checklist_id = ? AND film_id = ?";
    private String SQL_GET_ALL_BY_ID = "SELECT * FROM checklists WHERE user_id = ?";
    private String SQL_GET_ALL = "SELECT * FROM checklists";
    private String SQL_INSERT_IN = "INSERT INTO checklist_film (checklist_id, film_id) VALUES ((SELECT checklist_id FROM checklists WHERE user_id = ? AND name = ?), ?);";
    private String SQL_GET_BY_ID = "SELECT * FROM checklists WHERE checklist_id = ?";
    private String SQL_DELETE_CH = "DELETE FROM checklists WHERE checklist_id = ?";

    private Connection connection;

    public ChecklistDAO() {
        try {
            connection = ConnectHelper.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(String checklist, int user_id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_INSERT);
            st.setString(1, checklist);
            st.setInt(2, user_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Checklist adr) {
    }

    @Override
    public Checklist getById(int id) {
        Checklist checklist = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_GET_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                checklist = new Checklist(id, rs.getString("name"), rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checklist;
    }

    @Override
    public void update(Checklist adr) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Checklist> getAll() {
        List<Checklist> checklists = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_GET_ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Checklist checklist = new Checklist(rs.getInt("checklist_id"), rs.getString("name"),
                        rs.getInt("user_id"));
                checklists.add(checklist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checklists;
    }

    public List<Checklist> getAllById(int id) {
        List<Checklist> checklists = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_GET_ALL_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Checklist checklist = new Checklist(rs.getInt("checklist_id"), rs.getString("name"), id);
                checklists.add(checklist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checklists;
    }

    public void insertFilm(String checklist, int user_id, int film_id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_INSERT_IN);
            st.setInt(1, user_id);
            st.setString(2, checklist);
            st.setInt(3, film_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFilm(int checklist_id, int film_id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_DELETE_FILM);
            st.setInt(1, checklist_id);
            st.setInt(2, film_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteChecklist(int checklist_id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_DELETE_CH);
            st.setInt(1, checklist_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
