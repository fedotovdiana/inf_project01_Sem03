package servlets;

import models.Film;
import org.json.JSONArray;
import org.json.JSONObject;
import services.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    FilmService filmService;

    @Override
    public void init() throws ServletException {
        filmService = new FilmService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");

        List<Film> films = filmService.getByLikePattern(query);
        System.out.println(films.size());

        JSONArray ja = new JSONArray();
        for (Film film : films) {
            ja.put(new JSONObject(film));
        }
        JSONObject jo = new JSONObject();
        jo.put("objects", ja);
        System.out.println("dddd");

        response.setContentType("text/json");
        response.getWriter().write(jo.toString());
    }
}
