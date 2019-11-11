package servlets;

import helpers.Helper;
import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SettingsServlet")
@MultipartConfig
public class SettingsServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User current_user = (User) request.getSession().getAttribute("user");
        int id = current_user.getId();
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = null;
        try {
            password = userService.hash(request.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Part p = request.getPart("photo");
        String photo;
        if (!("".equals(p.getSubmittedFileName()))) {
            String localdir = "uploads";
            String pathDir = getServletContext().getRealPath("") + File.separator + localdir;
            File dir = new File(pathDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String[] filename_data = p.getSubmittedFileName().split("\\.");
            String filename = Math.random() + "." + filename_data[filename_data.length - 1];
            String fullpath = pathDir + File.separator + filename;
            p.write(fullpath);
            photo = "" + localdir + "/" + filename;
        } else {
            photo = current_user.getPhoto();
        }
        try {
            userService.update(id, name, login, password, photo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = userService.getUser(id);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        root.put("user", user);
        Helper.render(request, response, "settings.ftl", root);
    }
}
