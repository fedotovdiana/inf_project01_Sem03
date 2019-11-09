package servlets;

import helpers.Helper;
import models.Film;
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

@WebServlet(name = "AfishaServlet")
public class AfishaServlet extends HttpServlet {

    private FilmService filmService;

    @Override
    public void init() throws ServletException {
        filmService = new FilmService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO getAfishaFilms()
        List<Film> films = filmService.getAfishaFilms();
        Map<String, Object> root = new HashMap<>();
        root.put("films", films);
        Helper.render(request, response, "afisha.ftl", root);
    }
}
