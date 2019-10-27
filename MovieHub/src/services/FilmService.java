package services;

import dao.FilmDAO;
import models.Actor;
import models.Film;
import models.Producer;
import models.Scriptwriter;

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
}
