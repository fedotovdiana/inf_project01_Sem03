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

    private UserService userService;
    private ChecklistService checklistService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        checklistService = new ChecklistService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        checklistService.add(request.getParameter("input"), user.getId());
        request.getRequestDispatcher("/film").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/profile").forward(request, response);
    }
}
