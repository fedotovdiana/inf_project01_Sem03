package servlets;

import helpers.Helper;
import models.Film;
import services.ChecklistService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ChecklistServlet")
public class ChecklistServlet extends HttpServlet {

    ChecklistService checklistService = new ChecklistService();
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checklist_name = request.getParameter("checklist");
        String login = (String) request.getSession().getAttribute("user");
        int user_id = userService.getUser(login).getId();
        List<Film> films = checklistService.getFilms(checklist_name, user_id);
        Map<String, Object> root = new HashMap<>();
        root.put("films", films);
        Helper.render(request, response, "checklist.ftl", root);
    }
}
