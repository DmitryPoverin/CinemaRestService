package cinema.service.exeptions;

import javax.ws.rs.core.Response;

public class EntityNotFoundException extends RestException {
    public EntityNotFoundException(String message) {
        super(message);
        status = Response.Status.NOT_FOUND;
    }

}
