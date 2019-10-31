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

    public Film getFilm(String name) {
        return filmDAO.getByName(name);
    }

    public List<Actor> getActors(Film film) {
        return filmDAO.getActors(film);
    }

    public List<Producer> getProducers(Film film) {
        return filmDAO.getProducers(film);
    }

    public List<Scriptwriter> getScriptwriters(Film film) {
        return filmDAO.getScriptwriters(film);
    }

    public List<Category> getCategories(Film film) {
        return filmDAO.getCategories(film);
    }

    public List<Comment> getComments(Film film) {
        return filmDAO.getComments(film);
    }

    public void addComment(String user, String text, Timestamp timestamp, int film_id) {
        filmDAO.addComment(user, text, timestamp, film_id);
    }
}
