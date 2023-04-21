package com.iti.jets.sakilaJax.controllers.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DeleteFailedExceptionMapper implements ExceptionMapper<DeleteFailedException> {
    @Override
    public Response toResponse(DeleteFailedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 205, "Delete Failed");
        return Response.status(Response.Status.CONFLICT).entity(errorMessage).build();
    }
}
