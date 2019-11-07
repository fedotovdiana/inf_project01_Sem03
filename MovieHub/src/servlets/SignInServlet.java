package servlets;

import helpers.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//вход
@WebServlet(name = "SingInServlet")
public class SignInServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        //если есть в сессии, редирект к фильмам
        if (user != null) {
            response.sendRedirect("/films");
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            //если нет, но уже зарегистрирован, добавляем в сессию
            if (userService.find(login, password)) {
                session.setAttribute("user", login);
                response.sendRedirect("/films");
                //если не зарегистрирован
            } else {
                response.sendRedirect("/sign_up");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equals(c.getName())) {
                    System.out.println(c.getValue());
                    break;
                }
            }
        }
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        //если есть в сессии, редирект к фильмам
        if (user != null) {
            response.sendRedirect("/films");
        } else {
            Helper.render(request, response, "sign_in.ftl", null);
        }
    }
}
