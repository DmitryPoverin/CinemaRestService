package cinema.service.controllers;

import cinema.service.exeptions.EntityNotFoundException;
import cinema.service.exeptions.SeatAlreadyReservedException;
import cinema.service.exeptions.SeatAlreadyTakenException;
import cinema.service.model.Entity;
import cinema.service.model.Message;
import cinema.service.repositories.ICinemaService;
import cinema.service.reservation.ReservationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cinemas")
public class CinemaRestController {

    @Inject
    ICinemaService cinemaService;

    @Inject
    ReservationService reservationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable getAllCinemas() {
        Iterable cinemas = cinemaService.findAllCinemas();
        return cinemas;
    }

    @GET
    @Path("{id_cinema}/sessions")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable getCinemaSessions(@PathParam("id_cinema") Long idCinema) throws EntityNotFoundException {
        Iterable sessions = cinemaService.findAllSessionsInCinema(idCinema);
        return sessions;
    }

    @GET
    @Path("{id_cinema}/sessions/{id_session}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entity getSeatsSession(@PathParam("id_cinema") Long idCinema, @PathParam("id_session") Long idSession) throws EntityNotFoundException {
        return cinemaService.findSessionById(idCinema, idSession).getHall();
    }

    @PUT
    @Path("{id_cinema}/sessions/{id_session}/reserve")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reserveSeats(@PathParam("id_cinema") Long idCinema,
                                 @PathParam("id_session") Long idSession,
                                 @QueryParam("seat_id") List<Long> idSeats) throws EntityNotFoundException, SeatAlreadyReservedException, SeatAlreadyTakenException {
        reservationService.setReservationSeat(idCinema, idSession, idSeats, cinemaService);
        Response responce = Response.status(Response.Status.OK)
                .entity(new Message("Бронирование мест успешно выполнено",
                        Response.Status.OK.getStatusCode(),
                        idSeats))
                .build();
        return responce;
    }
}