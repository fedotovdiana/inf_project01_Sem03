package services;

import dao.StarDAO;
import models.Actor;
import models.Producer;
import models.Scriptwriter;

public class StarService {

    StarDAO starDAO = new StarDAO();

    public Actor getActor(String name) {
        return starDAO.getActorByName(name);
    }

    public Producer getProducer(String name) {
        return starDAO.getProducerByName(name);
    }

    public Scriptwriter getScriptwriter(String name) {
        return starDAO.getScriptwriterByName(name);
    }
}
