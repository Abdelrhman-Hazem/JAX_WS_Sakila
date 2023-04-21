package com.iti.jets.sakilaJax.controllers.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WrongParametersExceptionMapper implements ExceptionMapper<WrongParametersException> {
    @Override
    public Response toResponse(WrongParametersException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 206, "Wrong Parameters Entered");
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(errorMessage).build();
    }
}
