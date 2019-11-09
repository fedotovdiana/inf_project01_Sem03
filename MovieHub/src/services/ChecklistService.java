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

    public List<Film> getFilms(int checklist_id) {
        return filmDAO.getFilms(checklist_id);
    }

    public void addFilm(String checklist, int user_id, int film_id) {
        checklistDAO.insertFilm(checklist, user_id, film_id);
    }

    public void removeFilm(int checklist_id, int film_id) {
        checklistDAO.deleteFilm(checklist_id, film_id);
    }

    public Checklist getChecklistById(int checklist_id) {
        return checklistDAO.getById(checklist_id);
    }

    public void deleteChecklist(int checklist_id) {
        checklistDAO.deleteChecklist(checklist_id);
    }
}
