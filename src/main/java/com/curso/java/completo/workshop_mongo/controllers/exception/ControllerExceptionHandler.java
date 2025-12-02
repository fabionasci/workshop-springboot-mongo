package com.curso.java.completo.workshop_mongo.controllers.exception;

import com.curso.java.completo.workshop_mongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> handleObjectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){

        StandardError err = new StandardError(404, "Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(404).body(err);
    }
}
