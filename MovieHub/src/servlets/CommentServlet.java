package servlets;

import models.User;
import org.json.JSONObject;
import services.FilmService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {

    private UserService userService = new UserService();
    private FilmService filmService = new FilmService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String)request.getSession().getAttribute("user");
        User user = userService.getUser(login);
        int film_id = filmService.getFilm(request.getParameter("film_name")).getId();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yy");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        filmService.addComment(user.getName(),
                request.getParameter("text"), timestamp, film_id);
        JSONObject jo = new JSONObject();
        jo.put("user_name", user.getName());
        jo.put("date", "" + sdf.format(timestamp));
        response.setContentType("text/json");
        response.getWriter().write(jo.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
