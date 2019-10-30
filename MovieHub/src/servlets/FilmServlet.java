package servlets;

import helpers.Helper;
import models.*;
import services.ChecklistService;
import services.FilmService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FilmServlet")
public class FilmServlet extends HttpServlet {

    private FilmService filmService = new FilmService();
    private UserService userService = new UserService();
    private ChecklistService checklistService = new ChecklistService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Film film = filmService.getFilm(request.getParameter("name"));
        String login = (String) request.getSession().getAttribute("user");
        User user = userService.getUser(login);
        checklistService.addFilm(request.getParameter("input"), user.getId(), film.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Film film = filmService.getFilm(name);
        List<Actor> actors = filmService.getActors(film);
        List<Producer> producers = filmService.getProducers(film);
        List<Scriptwriter> scriptwriters = filmService.getScriptwriters(film);
        List<Category> categories = filmService.getCategories(film);
        List<Comment> comments = filmService.getComments(film);
        List<Checklist> checklists = new ArrayList<>();
        String login = (String) request.getSession().getAttribute("user");
        if (login != null) {
            User user = userService.getUser(login);
            checklists= checklistService.getAllByID(user.getId());
        }
        Map<String, Object> root = new HashMap<>();
        root.put("user", login);
        root.put("film", film);
        root.put("actors", actors);
        root.put("producers", producers);
        root.put("scriptwriters", scriptwriters);
        root.put("categories", categories);
        root.put("comments", comments);
        root.put("checklists", checklists);
        Helper.render(request, response, "film.ftl", root);
    }
}
