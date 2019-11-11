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
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = null;
        try {
            password = userService.hash(request.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

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

        Cookie cookie = new Cookie("user", login);
        cookie.setMaxAge(60 * 60 * 24 * 14);
        response.addCookie(cookie);
        try {
            userService.register(name, login, password, photo);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userService.getUser(login);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/films");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Helper.render(request, response, "sign_up.ftl", null);
    }
}

//    HttpSession session = request.getSession();
//    User user = (User) session.getAttribute("user");
//        if (user != null) {
//                response.sendRedirect("/films");
//                } else {
//                Cookie[] cookies = request.getCookies();
//                Cookie cookie = null;
//                if (cookies != null) {
//                for (Cookie c : cookies) {
//                if ("user".equals(c.getName())) {
//                cookie = c;
//                System.out.println(c.getValue());
//                break;
//                }
//                }
//                if (cookie != null) {
//                User u = userService.getUser(cookie.getValue());
//                request.getSession().setAttribute("user", u);
//                response.sendRedirect("/films");
//                } else {
//                Helper.render(request, response, "sign_up.ftl", null);
//                }
//                } else {
//                Helper.render(request, response, "sign_up.ftl", null);
//                }
//                }