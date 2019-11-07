package services;

import dao.StarDAO;
import models.Actor;
import models.Producer;
import models.Scriptwriter;

import java.util.List;

public class StarService {

    StarDAO starDAO = new StarDAO();

    public Actor getActor(int id) {
        return starDAO.getActorById(id);
    }

    public Producer getProducer(int id) {
        return starDAO.getProducerById(id);
    }

    public Scriptwriter getScriptwriter(int id) {
        return starDAO.getScriptwriterById(id);
    }

    public List<Actor> getAllActors() {
        return starDAO.getAllActors();
    }

    public List<Producer> getAllProducers() {
        return starDAO.getAllProducers();
    }

    public List<Scriptwriter> getAllScriptwriters() {
        return starDAO.getAllScriptwriters();
    }
}
