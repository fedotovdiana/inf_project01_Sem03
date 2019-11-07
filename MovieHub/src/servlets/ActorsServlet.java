package servlets;

import helpers.Helper;
import models.Actor;
import services.StarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ActorsServlet")
public class ActorsServlet extends HttpServlet {

    StarService starService;

    @Override
    public void init() throws ServletException {
        starService = new StarService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Actor> actors = starService.getAllActors();
        Map<String, Object> root = new HashMap<>();
        root.put("actors", actors);
        Helper.render(request, response, "actors.ftl", root);
    }
}
