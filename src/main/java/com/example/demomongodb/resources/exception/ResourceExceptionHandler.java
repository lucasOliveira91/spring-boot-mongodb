package com.example.demomongodb.resources.exception;

import com.example.demomongodb.exception.ObjectNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by loliveira on 25/12/18.
 */
@ControllerAdvice //it means that this class see erros
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoudException.class)
    public ResponseEntity<StantardError> objectNotFoud(ObjectNotFoudException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StantardError err = new StantardError(
                System.currentTimeMillis(),
                status.value(), "Not Foud",
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
