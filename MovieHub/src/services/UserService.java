package services;

import dao.UserDAO;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void register(String name, String login, String password, String photo) {
        userDAO.insert(name, login, password, photo);
    }

    public boolean find(String login, String password) {
        return userDAO.isExist(login, password);
    }
}
