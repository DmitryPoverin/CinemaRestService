package cinema.service.exeptions;

import cinema.service.model.Message;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrowableExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Response.Status status;
        if(exception instanceof RestException)
            status = ((RestException) exception).getStatus();
        else
            status = Response.Status.INTERNAL_SERVER_ERROR;
        Message msg = new Message(exception.getMessage(),status.getStatusCode());
        Response response = Response.status(status).entity(msg).build();
        return response;
    }
}
