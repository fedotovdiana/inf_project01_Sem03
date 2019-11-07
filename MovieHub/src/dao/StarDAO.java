package dao;

import helpers.ConnectHelper;
import models.Actor;
import models.Producer;
import models.Scriptwriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarDAO implements DAO<Actor> {

    //language=SQL
    private String SQL_SELECT_ACTOR = "SELECT * FROM actors WHERE id = ?";
    private String SQL_SELECT_SCRIPTWRITER = "SELECT * FROM scriptwriters WHERE id = ?";
    private String SQL_SELECT_PRODUCER = "SELECT * FROM producers WHERE id = ?";
    private String SQL_SELECT_ALL_ACTORS = "SELECT * FROM actors";
    private String SQL_SELECT_ALL_PRODUCERS = "SELECT * FROM producers";
    private String SQL_SELECT_ALL_SCRIPTWRITERS = "SELECT * FROM scriptwriters";

    private Connection connection;

    public StarDAO() {
        try {
            connection = ConnectHelper.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Actor adr) {

    }

    @Override
    public Actor getById(int id) {
        return null;
    }

    @Override
    public void update(Actor adr) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Actor> getAll() {
        return null;
    }

    public Actor getActorById(int id) {
        Actor actor = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ACTOR);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                actor = new Actor(id, rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    public Producer getProducerById(int id) {
        Producer producer = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_PRODUCER);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                producer = new Producer(id, rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producer;
    }

    public Scriptwriter getScriptwriterById(int id) {
        Scriptwriter scriptwriter = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_SCRIPTWRITER);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                scriptwriter = new Scriptwriter(id, rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scriptwriter;
    }

    public List<Actor> getAllActors() {
        List<Actor> actors = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ALL_ACTORS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public List<Producer> getAllProducers() {
        List<Producer> producers = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ALL_PRODUCERS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producer producer = new Producer(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    public List<Scriptwriter> getAllScriptwriters() {
        List<Scriptwriter> scriptwriters = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ALL_SCRIPTWRITERS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Scriptwriter scriptwriter = new Scriptwriter(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
                scriptwriters.add(scriptwriter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scriptwriters;
    }
}
