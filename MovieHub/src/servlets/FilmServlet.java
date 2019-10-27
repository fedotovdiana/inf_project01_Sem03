package servlets;

import helpers.Helper;
import models.*;
import services.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FilmServlet")
public class FilmServlet extends HttpServlet {

    private FilmService filmService = new FilmService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Map<String, Object> root = new HashMap<>();
        Film film = filmService.getFilm(name);
        List<Actor> actors = filmService.getActors(film);
        List<Producer> producers = filmService.getProducers(film);
        List<Scriptwriter> scriptwriters = filmService.getScriptwriters(film);
        List<Category> categories = filmService.getCategories(film);
        root.put("film", film);
        root.put("actors", actors);
        root.put("producers", producers);
        root.put("scriptwriters", scriptwriters);
        root.put("categories", categories);
        Helper.render(request, response, "film.ftl", root);
    }
}
