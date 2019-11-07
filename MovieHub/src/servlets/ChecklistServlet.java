package servlets;

import helpers.Helper;
import models.Checklist;
import models.Film;
import services.ChecklistService;
import services.StarService;
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

    ChecklistService checklistService;
    UserService userService;

    @Override
    public void init() throws ServletException {
        checklistService = new ChecklistService();
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int checklist_id = Integer.parseInt(request.getParameter("checklist_id"));
        Checklist checklist = checklistService.getChecklistById(checklist_id);
        List<Film> films = checklistService.getFilms(checklist_id);
        Map<String, Object> root = new HashMap<>();
        root.put("films", films);
        root.put("checklist", checklist);
        Helper.render(request, response, "checklist.ftl", root);
    }
}
