package services;

import dao.StarDAO;
import models.Actor;
import models.Producer;
import models.Scriptwriter;

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
}
