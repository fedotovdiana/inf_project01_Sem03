package services;

import dao.ChecklistDAO;
import dao.FilmDAO;
import models.Checklist;
import models.Film;

import java.util.List;

public class ChecklistService {

    ChecklistDAO checklistDAO = new ChecklistDAO();
    FilmDAO filmDAO = new FilmDAO();

    public void add(String checklist, int user_id) {
        checklistDAO.insert(checklist, user_id);
    }

    public List<Checklist> getAllByID(int id) {
        return checklistDAO.getAllById(id);
    }

    public List<Film> getFilms(String checklist_name, int user_id) {
        return filmDAO.getFilms(checklist_name, user_id);
    }

    public void addFilm(String checklist, int user_id, int film_id) {
        checklistDAO.insertFilm(checklist, user_id, film_id);
    }
}
