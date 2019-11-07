package servlets;

import helpers.Helper;
import models.Scriptwriter;
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

@WebServlet(name = "ScriptwritersServlet")
public class ScriptwritersServlet extends HttpServlet {

    StarService starService;

    @Override
    public void init() throws ServletException {
        starService = new StarService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Scriptwriter> scriptwriters = starService.getAllScriptwriters();
        Map<String, Object> root = new HashMap<>();
        root.put("scriptwriters", scriptwriters);
        Helper.render(request, response, "scriptwriters.ftl", root);
    }
}
