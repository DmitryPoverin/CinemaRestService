package cinema.service.exeptions;

public class SeatAlreadyTakenException extends RestException{
    public SeatAlreadyTakenException(String message) {
        super(message);
    }
}
