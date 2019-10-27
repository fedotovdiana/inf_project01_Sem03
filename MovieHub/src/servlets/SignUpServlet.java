package servlets;

import helpers.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//registration
@WebServlet(name = "SingUpServlet")
public class SignUpServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String photo = request.getParameter("photo");
        //если нет, но уже зарегистрирован
        if (userService.find(login, password)) {
            session.setAttribute("user", login);
            response.sendRedirect("/films");
            //если не зарегистрирован, зарегистрировать
        } else {
            userService.register(name, login, password, photo);
            response.sendRedirect("/films");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        //если есть в сессии, редирект к фильмам
        if (user != null) {
            response.sendRedirect("/films");
        } else {
            Helper.render(request, response, "sign_up.ftl", null);
        }
    }

}

//    @Override
//    protected void doPost(
//            HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        RequestCustomer customer = RequestCustomer.fromRequestParameters(request);
//        customer.setAsRequestAttributes(request);
//        List violations = customer.validate();
//
//        if (!violations.isEmpty()) {
//            request.setAttribute("violations", violations);
//        }
//
//        String url = determineUrl(violations);
//        request.getRequestDispatcher(url).forward(request, response);
//    }
//
//    private String determineUrl(List violations) {
//        if (!violations.isEmpty()) {
//            return "/";
//        } else {
//            return "/WEB-INF/views/customerinfo.jsp";
//        }
//    }
//
//    private static class RequestCustomer {
//
//        private final String firstName;
//        private final String lastName;
//        private final String email;
//
//        private RequestCustomer(String firstName, String lastName, String email) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.email = email;
//        }
//
//        public static RequestCustomer fromRequestParameters(
//                HttpServletRequest request) {
//            return new RequestCustomer(
//                    request.getParameter("firstname"),
//                    request.getParameter("lastname"),
//                    request.getParameter("email"));
//        }
//
//        public void setAsRequestAttributes(HttpServletRequest request) {
//            request.setAttribute("firstname", firstName);
//            request.setAttribute("lastname", lastName);
//            request.setAttribute("email", email);
//        }
//
//        public List validate() {
//            List violations = new ArrayList<>();
//            if (!StringValidator.validate(firstName)) {
//                violations.add("Имя является обязательным полем");
//            }
//            if (!StringValidator.validate(lastName)) {
//                violations.add("Фамилия является обязательным полем");
//            }
//            if (!EmailValidator.validate(email)) {
//                violations.add("Email должен быть правильно сформирован");
//            }
//            return violations;
//        }
//
//    }
//}
