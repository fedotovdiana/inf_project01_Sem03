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

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {

    UserService userService;
    ChecklistService checklistService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        checklistService = new ChecklistService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("kkkkkkkkkkkkkkkkkkk");
        System.out.println(request.getParameter("checklist_id"));
        int checklist_id = Integer.parseInt(request.getParameter("checklist_id"));
        System.out.println(checklist_id);
        checklistService.deleteChecklist(checklist_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
