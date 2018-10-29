package cinema.service.helpers;

import cinema.service.model.*;
import cinema.service.repositories.ICinemaService;
import cinema.service.storage.CinemasStorage;

import javax.inject.Inject;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Helper {

    public void initFilms(){
        CinemasStorage.addFilm(new FilmInfo(1L, "Собачье сердце", "Владимир Владимирович Бортко", (byte) 136));
        CinemasStorage.addFilm(new FilmInfo(2L, "Они сражались за Родину", "Сергей Фёдорович Бондарчук", (byte) 152));
        CinemasStorage.addFilm(new FilmInfo(3L, "Белые росы", "Игорь Добролюбов", (byte) 84));
        CinemasStorage.addFilm(new FilmInfo(4L, "Математик и чёрт", "Семен Райтбурт", (byte) 21));
    }

    public void initCinemas(){
        long countFilms = CinemasStorage.getCountFilms();
        long hallCapacity = 200;
        buildCinema(1, "Синема парк", countFilms, hallCapacity);
        buildCinema(2, "Аврора", countFilms, hallCapacity);
        buildCinema(3, "Киносити", countFilms, hallCapacity);
        buildCinema(4, "Победа", countFilms, hallCapacity);
        buildCinema(5, "Pacific Theatres at the Grove", countFilms, hallCapacity);
    }

    public void buildCinema(long id, String name, long capacity, long hallCapacity){

        long count_halls = capacity;
        long count_session  = capacity;
        long count_seats_in_hall = hallCapacity;
        Cinema cinema = new Cinema(id, name);
        ConcurrentMap<Long, Hall> halls = new ConcurrentHashMap<>();
        for(long j = 1; j <= count_halls; j++){
            ConcurrentMap<Long, Seat> seats = new ConcurrentHashMap<>();
            for(long i = 1; i <= count_seats_in_hall; i++){
                seats.put(i, new Seat(i));
            }
            Hall hall= new Hall(j, seats);
            cinema.addHall(hall);
        }

        for(long i = 1; i <= count_session; i++){
            try {
                cinema.createNewSession(i, new Date(), new Date(), CinemasStorage.getFilmInfo(i), i);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        CinemasStorage.addCinema(cinema);
    }
}
