package cinema.service.exeptions;

import javax.ws.rs.core.Response;

public abstract class RestException extends Throwable {
    public RestException(String message) {
        super(message);
        status = Response.Status.INTERNAL_SERVER_ERROR;
    }
    protected Response.Status status;

    public Response.Status getStatus() {
        return status;
    }
}
