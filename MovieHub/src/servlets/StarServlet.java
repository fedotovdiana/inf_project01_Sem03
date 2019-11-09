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

    StarService starService;

    @Override
    public void init() throws ServletException {
        starService = new StarService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        if (request.getParameter("producer_id") != null) {
            int id = Integer.parseInt(request.getParameter("producer_id"));
            System.out.println("fffffff" + id);
            root.put("star", starService.getProducer(id));
        }
        if(request.getParameter("actor_id") != null) {
            int id = Integer.parseInt(request.getParameter("actor_id"));
            root.put("star", starService.getActor(id));
        }
        if (request.getParameter("scr_id") != null) {
            int id = Integer.parseInt(request.getParameter("scr_id"));
            root.put("star", starService.getScriptwriter(id));
        }
        Helper.render(request, response, "star.ftl", root);
    }
}
