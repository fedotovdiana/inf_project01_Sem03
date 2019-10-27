package services;

import dao.UserDAO;
import models.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void register(String name, String login, String password, String photo) {
        userDAO.insert(name, login, password, photo);
    }

    public boolean find(String login, String password) {
        return userDAO.isExist(login, password);
    }

    public User getUser(String login) {
        return userDAO.getUserByLogin(login);
    }

    public void update(int id, String name, String login, String password, String photo) {
        userDAO.update(id, name, login, password, photo);
    }
}
