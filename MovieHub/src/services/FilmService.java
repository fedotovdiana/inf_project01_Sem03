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

    public int getLikes(int film_id) {
        return filmDAO.getLikes(film_id);
    }

    public int getDislikes(int film_id) {
        return filmDAO.getDislikes(film_id);
    }

    public void addLike(int user_id, int film_id) {
        filmDAO.addLike(user_id, film_id);
    }

    public void addDislike(int user_id, int film_id) {
        filmDAO.addDislike(user_id, film_id);
    }

    public List<Film> getTopFilms() {
        return filmDAO.getTopFilms();
    }

    public List<Film> getAfishaFilms() {
        return filmDAO.getAfishaFilms();
    }

    public List<Film> getByLikePattern(String pattern) {
        return filmDAO.getByLikePattern(pattern);
    }
}
