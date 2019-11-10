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

//registration
@WebServlet(name = "SingUpServlet")
@MultipartConfig
public class SignUpServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POOOOOOOOOST");
        HttpSession session = request.getSession();
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

        if (userService.find(login, password)) {
            response.sendRedirect("/profile");
        } else {
//            Cookie cookie = new Cookie("user", login);
//            response.addCookie(cookie);
            userService.register(name, login, password, photo);
            User user = userService.getUser(login);
            session.setAttribute("user", user);
            response.sendRedirect("/films");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            response.sendRedirect("/films");
        } else {
            Helper.render(request, response, "sign_up.ftl", null);
        }
    }
}
