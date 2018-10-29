package cinema.service.exeptions;

public class SeatAlreadyReservedException extends RestException {
    public SeatAlreadyReservedException(String message) {
        super(message);
    }
}
