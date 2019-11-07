package servlets;

import helpers.Helper;
import models.Producer;
import services.StarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProducersServlet")
public class ProducersServlet extends HttpServlet {

    StarService starService;

    @Override
    public void init() throws ServletException {
        starService = new StarService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producer> producers = starService.getAllProducers();
        System.out.println(producers.size());
        Map<String, Object> root = new HashMap<>();
        root.put("producers", producers);
        Helper.render(request, response, "producers.ftl", root);
    }
}
