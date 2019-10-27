package dao;

import helpers.ConnectHelper;
import models.Actor;
import models.Producer;
import models.Scriptwriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StarDAO implements DAO<Actor> {

    //language=SQL
    private String SQL_SELECT_ACTOR = "SELECT * FROM actors WHERE name = ?";
    private String SQL_SELECT_SCRIPTWRITER = "SELECT * FROM scriptwriters WHERE name = ?";
    private String SQL_SELECT_PRODUCER = "SELECT * FROM producers WHERE name = ?";

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

    public Actor getActorByName(String name) {
        Actor actor = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ACTOR);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                actor = new Actor(rs.getInt("id"), name, rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    public Producer getProducerByName(String name) {
        Producer producer = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_PRODUCER);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                producer = new Producer(rs.getInt("id"), name, rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producer;
    }

    public Scriptwriter getScriptwriterByName(String name) {
        Scriptwriter scriptwriter = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_SCRIPTWRITER);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                scriptwriter = new Scriptwriter(rs.getInt("id"), name, rs.getString("country"),
                        rs.getString("birthday"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scriptwriter;
    }
}
