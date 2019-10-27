package servlets;

import helpers.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SettingsServlet")
public class SettingsServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //достать все параметры юзера и обновить их с юзерсервис - юзердао
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String photo = request.getParameter("photo");
        String current_login = (String)request.getSession().getAttribute("user");
        int id = userService.getUser(current_login).getId();
        userService.update(id, name,login, password, photo);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        String login = (String)request.getSession().getAttribute("user");
        root.put("user", userService.getUser(login));
        Helper.render(request, response, "settings.ftl", root);
    }
}
