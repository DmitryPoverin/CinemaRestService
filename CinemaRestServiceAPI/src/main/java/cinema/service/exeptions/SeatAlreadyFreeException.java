package cinema.service.exeptions;

public class SeatAlreadyFreeException extends RestException {
    public SeatAlreadyFreeException(String message) {
        super(message);
    }
}
