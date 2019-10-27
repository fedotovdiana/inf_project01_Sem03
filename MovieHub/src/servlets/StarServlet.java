package servlets;

import helpers.Helper;
import services.StarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "StarServlet")
public class StarServlet extends HttpServlet {

    StarService starService = new StarService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        if (request.getParameter("producer_name") != null) {
            String name = request.getParameter("producer_name");
            root.put("star", starService.getProducer(name));
        }
        if(request.getParameter("actor_name") != null) {
            String name = request.getParameter("actor_name");
            root.put("star", starService.getActor(name));
        }
        if (request.getParameter("scr_name") != null) {
            String name = request.getParameter("scr_name");
            root.put("star", starService.getScriptwriter(name));
        }
        Helper.render(request, response, "star.ftl", root);
    }
}
