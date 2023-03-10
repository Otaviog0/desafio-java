package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
        protected ResponseEntity<Object> handleConflict(
                RuntimeException ex, WebRequest request) {
            String bodyOfResponse = "This should be application specific";
            return handleExceptionInternal(ex, bodyOfResponse,
                    new HttpHeaders(), HttpStatus.CONFLICT, request);
        }

        @ExceptionHandler(value = { EntityNotFound.class })
        protected ResponseEntity<Object> handleNotFound(EntityNotFound ex, WebRequest request) {
            String bodyOfResponse = ex.getMessage();
            return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
        }
}