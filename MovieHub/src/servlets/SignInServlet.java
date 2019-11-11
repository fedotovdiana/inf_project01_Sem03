package servlets;

import helpers.Helper;
import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "SingInServlet")
public class SignInServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = null;
        try {
            password = userService.hash(request.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String checkbox = request.getParameter("check");
        try {
            if (userService.find(login, password)) {
                User n_user = userService.getUser(login);
                request.getSession().setAttribute("user", n_user);
                if (checkbox != null) {
                    Cookie cookie = new Cookie("user", login);
                    cookie.setMaxAge(60 * 60 * 24 * 14);
                    response.addCookie(cookie);
                }
                response.sendRedirect("/films");
            } else {
                response.sendRedirect("/sign_up");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Helper.render(request, response, "sign_in.ftl", null);
    }
}

//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        if (user != null) {
//            response.sendRedirect("/films");
//        } else {
//            Cookie[] cookies = request.getCookies();
//            Cookie cookie = null;
//            if (cookies != null) {
//                for (Cookie c : cookies) {
//                    if ("user".equals(c.getName())) {
//                        cookie = c;
//                        System.out.println(c.getValue());
//                        break;
//                    }
//                }
//                if (cookie != null) {
//                    User u = userService.getUser(cookie.getValue());
//                    request.getSession().setAttribute("user", u);
//                    response.sendRedirect("/films");
//                } else {
//                    Helper.render(request, response, "sign_in.ftl", null);
//                }
//            } else {
//                Helper.render(request, response, "sign_in.ftl", null);
//            }
//        }