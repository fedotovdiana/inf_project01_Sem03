package services;

import dao.FilmDAO;
import models.*;

import java.sql.Timestamp;
import java.util.List;

public class FilmService {

    private FilmDAO filmDAO = new FilmDAO();

    public List<Film> getAllFilms() {
        return filmDAO.getAll();
    }

    public Film getFilm(int id) {
        return filmDAO.getById(id);
    }

    public List<Actor> getActors(int film_id) {
        return filmDAO.getActors(film_id);
    }

    public List<Producer> getProducers(int film_id) {
        return filmDAO.getProducers(film_id);
    }

    public List<Scriptwriter> getScriptwriters(int film_id) {
        return filmDAO.getScriptwriters(film_id);
    }

    public List<Category> getCategories(int film_id) {
        return filmDAO.getCategories(film_id);
    }

    public List<Comment> getComments(int film_id) {
        return filmDAO.getComments(film_id);
    }

    public void addComment(String user, String text, Timestamp timestamp, int film_id) {
        filmDAO.addComment(user, text, timestamp, film_id);
    }
}
