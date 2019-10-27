package dao;

import helpers.ConnectHelper;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements DAO<Film> {

    //language=SQL
    private String SQL_SELECT_BY_ID = "SELECT * FROM films WHERE id = ?";
    private String SQL_GET_ALL = "SELECT * FROM films";
    private String SQL_INSERT = "INSERT INTO films (name, login, password, photo) VALUES (?, ?, ?, ?)";
    private String SQL_DELETE = "DELETE FROM films WHERE id = ?";
    private String SQL_SELECT_BY_NAME = "SELECT * FROM films WHERE name = ?";
    private String SQL_SELECT_ACTORS = "SELECT * FROM actors WHERE id IN (SELECT actor_id FROM actor_film WHERE film_id = ?)";
    private String SQL_SELECT_PRODUCERS = "SELECT * FROM producers WHERE id IN (SELECT producer_id FROM producer_film WHERE film_id = ?)";
    private String SQL_SELECT_SCRIPTWRITERS = "SELECT * FROM scriptwriters WHERE id IN (SELECT scriptwriter_id FROM scriptwriter_film WHERE film_id = ?)";
    private String SQL_SELECT_CATEGORIES = "SELECT * FROM categories WHERE id IN (SELECT category_id FROM category_film WHERE film_id = ?)";

    private Connection connection;

    public FilmDAO() {
        try {
            connection = ConnectHelper.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Film adr) {

    }

    @Override
    public Film getById(int id) {
        Film film = null;
        try {
            PreparedStatement st = connection.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                film = new Film(id, rs.getString("name"), rs.getString("country"),
                        rs.getString("date"), rs.getInt("likes"), rs.getInt("dislikes"),
                        rs.getString("photo"), rs.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void update(Film adr) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_GET_ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Film film = new Film(rs.getInt("id"), rs.getString("name"), rs.getString("country"),
                        rs.getString("date"), rs.getInt("likes"), rs.getInt("dislikes"),
                        rs.getString("photo"), rs.getString("text"));
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }


    public Film getByName(String name) {
        Film film = null;
        try {
            PreparedStatement st = connection.prepareStatement(SQL_SELECT_BY_NAME);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                film = new Film(rs.getInt("id"), name, rs.getString("country"),
                        rs.getString("date"), rs.getInt("likes"), rs.getInt("dislikes"),
                        rs.getString("photo"), rs.getString("text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public List<Actor> getActors(Film film) {
        List<Actor> actors = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ACTORS);
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("country"), rs.getString("birthday"),
                        rs.getString("photo"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public List<Producer> getProducers(Film film) {
        List<Producer> producers = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_PRODUCERS);
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producer producer = new Producer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("country"), rs.getString("birthday"),
                        rs.getString("photo"));
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    public List<Scriptwriter> getScriptwriters(Film film) {
        List<Scriptwriter> scriptwriters = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_SCRIPTWRITERS);
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Scriptwriter scriptwriter = new Scriptwriter(rs.getInt("id"), rs.getString("name"),
                        rs.getString("country"), rs.getString("birthday"),
                        rs.getString("photo"));
                scriptwriters.add(scriptwriter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scriptwriters;
    }

    public List<Category> getCategories(Film film) {
        List<Category> categories = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_CATEGORIES);
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
