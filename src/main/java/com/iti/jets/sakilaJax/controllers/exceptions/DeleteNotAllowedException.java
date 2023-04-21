package com.iti.jets.sakilaJax.controllers.exceptions;

public class DeleteNotAllowedException extends RuntimeException{
    public DeleteNotAllowedException(String message) {
        super(message);
    }

}
