package dao;

import models.User;
import helpers.ConnectHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {

    //language=SQL
    private String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private String SQL_GET_ALL = "SELECT * FROM users";
    private String SQL_INSERT = "INSERT INTO users (name, login, password, photo) VALUES (?, ?, ?, ?)";
    private String SQL_DELETE = "DELETE FROM users WHERE id = ?";
    private String SQL_SELECT = "SELECT * FROM users WHERE login = ? AND password = ?";
    private String SQL_SELECT_LOGIN = "SELECT * FROM users WHERE login = ?";
    private String SQL_UPDATE = "UPDATE users SET name = ? , login = ?, password = ?, photo = ? WHERE id = ?";

    private Connection connection;

    public UserDAO() {
        try {
            connection = ConnectHelper.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void insert(String name, String login, String password, String photo) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_INSERT);
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, password);
            st.setString(4, photo);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User adr) {

    }

    @Override
    public User getById(int id) {
        User user = null;
        try {
            PreparedStatement st = connection.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User(id, rs.getString("name"), rs.getString("login"),
                        rs.getString("password"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public void update(User user) {

    }

    public void update(int id, String name, String login, String password, String photo) {
        try {
            PreparedStatement st = connection.prepareStatement(SQL_UPDATE);
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, password);
            st.setString(4, photo);
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = connection.prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_GET_ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("login"), rs.getString("password"), rs.getString("photo"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean isExist(String login, String password) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT);
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByLogin(String login) {
        User user = null;
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_LOGIN);
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"),
                        login, rs.getString("password"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

