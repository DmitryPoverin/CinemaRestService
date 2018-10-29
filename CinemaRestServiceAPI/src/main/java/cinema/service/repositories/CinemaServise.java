package cinema.service.repositories;

import cinema.service.exeptions.EntityNotFoundException;
import cinema.service.model.*;
import cinema.service.storage.CinemasStorage;

public class CinemaServise implements ICinemaService {

    @Override
    public Iterable<Cinema> findAllCinemas() {

        return CinemasStorage.getAllCinemas();
    }

    @Override
    public Iterable<SessionCinema> findAllSessionsInCinema(Long idCinema) throws EntityNotFoundException {
        Cinema cinema = findCinemaById(idCinema);
        return cinema.getAllSessions();
    }

    @Override
    public Cinema findCinemaById(Long idCinema) throws EntityNotFoundException {
        Cinema cinema = CinemasStorage.getCinema(idCinema);
        if(cinema == null)
            throw new EntityNotFoundException("Кинотеатр с id = " + idCinema.toString() + " не найден!");
        return CinemasStorage.getCinema(idCinema);
    }

    @Override
    public SessionCinema findSessionById(Long idCinema, Long idSession) throws EntityNotFoundException {
        Cinema cinema = findCinemaById(idCinema);
        SessionCinema sessionCinema = cinema.getSession(idSession);
        if(sessionCinema == null)
            throw new EntityNotFoundException("Сеанс с id = " + idCinema.toString() + " не найден!");
        return sessionCinema;
    }

    @Override
    public void updateSeatStatus(Long idCinema, Long idSession, Seat seat) {

    }
}
