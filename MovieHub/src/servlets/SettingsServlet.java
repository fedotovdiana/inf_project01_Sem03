package servlets;

import helpers.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
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
        //достать все параметры юзера и обновить их с юзерсервис - юзердао
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        //работа с фото
        Part p = request.getPart("photo");
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
        String photo = "" + localdir + "/" + filename;
        String current_login = (String) request.getSession().getAttribute("user");
        int id = userService.getUser(current_login).getId();
        userService.update(id, name, login, password, photo);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("user");
        root.put("user", userService.getUser(login));
        Helper.render(request, response, "settings.ftl", root);
    }
}
