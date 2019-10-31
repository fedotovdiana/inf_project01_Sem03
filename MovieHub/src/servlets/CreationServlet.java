package servlets;

import models.User;
import services.ChecklistService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreationServlet")
public class CreationServlet extends HttpServlet {

    private UserService userService = new UserService();
    private ChecklistService checklistService = new ChecklistService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String)request.getSession().getAttribute("user");
        User user = userService.getUser(login);
        checklistService.add(request.getParameter("input"), user.getId());
        request.getRequestDispatcher("/film").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/profile").forward(request, response);
    }
}
