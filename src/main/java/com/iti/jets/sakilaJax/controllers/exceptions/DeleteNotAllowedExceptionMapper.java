package com.iti.jets.sakilaJax.controllers.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DeleteNotAllowedExceptionMapper implements ExceptionMapper<DeleteFailedException> {
    @Override
    public Response toResponse(DeleteFailedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 207, "Delete Not Allowed");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(errorMessage).build();
    }
}
