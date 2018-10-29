package cinema.service.storage;

import cinema.service.model.Cinema;
import cinema.service.model.FilmInfo;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CinemasStorage {

    private static final ConcurrentMap<Long, Cinema> cinemas = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Long, FilmInfo> films = new ConcurrentHashMap<>();

    public static Iterable<Cinema> getAllCinemas(){
        Iterable<Cinema> list = new LinkedList<>(cinemas.values());
        return list;
    }

    public static Cinema getCinema(Long id){
        return cinemas.get(id);
    }

    public static FilmInfo getFilmInfo(Long id){
        return films.get(id);
    }

    public static void addCinema(Cinema cinema){
        cinemas.put(cinema.getId(), cinema);
    }

    public static void addFilm(FilmInfo filmInfo){
        films.put(filmInfo.getId(), filmInfo);
    }

    public static long getCountFilms(){
        return films.size();
    }
}
