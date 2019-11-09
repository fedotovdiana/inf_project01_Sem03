package servlets;

import com.sun.xml.internal.bind.v2.TODO;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FilmServlet")
public class FilmServlet extends HttpServlet {

    private FilmService filmService;
    private UserService userService;
    private ChecklistService checklistService;

    @Override
    public void init() throws ServletException {
        filmService = new FilmService();
        userService = new UserService();
        checklistService = new ChecklistService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //по айди getfilm
        //Film film = filmService.getFilm(request.getParameter("name"));
        User user = (User) request.getSession().getAttribute("user");
        int film_id = Integer.parseInt(request.getParameter("film_id"));
        checklistService.addFilm(request.getParameter("input"), user.getId(), film_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int film_id = Integer.parseInt(request.getParameter("film_id"));
        System.out.println(film_id);
        Film film = filmService.getFilm(film_id);
        List<Actor> actors = filmService.getActors(film_id);
        List<Producer> producers = filmService.getProducers(film_id);
        List<Scriptwriter> scriptwriters = filmService.getScriptwriters(film_id);
        List<Category> categories = filmService.getCategories(film_id);
        List<Comment> comments = filmService.getComments(film_id);
        List<Checklist> checklists = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            //по айди? и сессию переделать
            checklists = checklistService.getAllByID(user.getId());
        }
        int likes = filmService.getLikes(film_id);
        int dislikes = filmService.getDislikes(film_id);
        Map<String, Object> root = new HashMap<>();
        root.put("user", user);
        root.put("film", film);
        root.put("actors", actors);
        root.put("producers", producers);
        root.put("scriptwriters", scriptwriters);
        root.put("categories", categories);
        root.put("comments", comments);
        root.put("checklists", checklists);
        root.put("likes", likes);
        root.put("dislikes", dislikes);
        Helper.render(request, response, "film.ftl", root);
    }
}
