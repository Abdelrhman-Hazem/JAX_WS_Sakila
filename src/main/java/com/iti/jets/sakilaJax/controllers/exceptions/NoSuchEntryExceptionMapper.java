package com.iti.jets.sakilaJax.controllers.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoSuchEntryExceptionMapper implements ExceptionMapper<NoSuchEntryException> {
    @Override
    public Response toResponse(NoSuchEntryException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 204, "Entry Retrieving  Failed");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
