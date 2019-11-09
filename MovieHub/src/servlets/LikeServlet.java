package servlets;

import models.User;
import services.FilmService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LikeServlet")
public class LikeServlet extends HttpServlet {

    private FilmService filmService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        filmService = new FilmService();
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int film_id = Integer.parseInt(request.getParameter("film_id"));
        filmService.addLike(user.getId(), film_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
