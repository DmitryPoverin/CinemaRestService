package cinema.service.reservation;

import cinema.service.exeptions.EntityNotFoundException;
import cinema.service.model.Seat;
import cinema.service.model.SessionCinema;
import cinema.service.exeptions.SeatAlreadyFreeException;
import cinema.service.exeptions.SeatAlreadyReservedException;
import cinema.service.exeptions.SeatAlreadyTakenException;
import cinema.service.repositories.ICinemaService;

import java.util.List;

public class ReservationService {

    public void setReservationSeat(Long idCinema, Long idSession, List<Long> idSeats, ICinemaService cinemaService) throws SeatAlreadyReservedException, SeatAlreadyTakenException, EntityNotFoundException {
        SessionCinema sessionCinema = cinemaService.findSessionById(idCinema, idSession);
        for(Long id: idSeats){
            Seat seat = sessionCinema.getHall().getSeat(id);
            if(seat.isReserved())
                throw new SeatAlreadyReservedException("Место с id = " + id.toString() + " уже забронировано!");
            if(seat.isSales())
                throw new SeatAlreadyTakenException("Место с id = " + id.toString() + " уже занято!");
            seat.reserve();
            cinemaService.updateSeatStatus(idCinema, idSession, seat);
        }
    }

    public void cancelReservationSeat(Long idCinema, Long idSession, List<Long> idSeats, ICinemaService cinemaService) throws SeatAlreadyFreeException, SeatAlreadyTakenException, EntityNotFoundException {
        SessionCinema sessionCinema = cinemaService.findSessionById(idCinema, idSession);
        for(Long id: idSeats){
            Seat seat = sessionCinema.getHall().getSeat(id);
            if(seat.isSales())
                throw new SeatAlreadyTakenException("Место с id = " + id.toString() + " уже занято!");
            if(seat.isFree())
                throw new SeatAlreadyFreeException("Место с id = " + id.toString() + " свободно!");
            seat.free();
            cinemaService.updateSeatStatus(idCinema, idSession, seat);
        }
    }
}
