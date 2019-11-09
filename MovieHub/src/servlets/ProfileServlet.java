package servlets;

import helpers.Helper;
import models.Checklist;
import models.User;
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

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    UserService userService;
    ChecklistService checklistService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        checklistService = new ChecklistService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getId();
        String checklist = request.getParameter("checklist");
        checklistService.add(checklist, user_id);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Checklist> checklists = checklistService.getAllByID(user.getId());
        Map<String, Object> root = new HashMap<>();
        root.put("user", user);
        root.put("checklists", checklists);
        Helper.render(request, response, "profile.ftl", root);
    }
}
