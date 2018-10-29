package cinema.service.repositories;

import cinema.service.exeptions.EntityNotFoundException;
import cinema.service.model.*;

public interface ICinemaService {
    Iterable<Cinema> findAllCinemas();
    Iterable<SessionCinema> findAllSessionsInCinema(Long idCinema) throws EntityNotFoundException;

    Cinema findCinemaById(Long idCinema) throws EntityNotFoundException;
    SessionCinema findSessionById(Long idCinema, Long idSession) throws EntityNotFoundException;

    void updateSeatStatus(Long idCinema, Long idSession, Seat seat);
}
