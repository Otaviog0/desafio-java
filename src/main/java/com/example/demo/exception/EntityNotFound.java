package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"cause","stackTrace","suppressed", "localizedMessage"})
public class EntityNotFound extends RuntimeException {

    private final String code = "02";

    public String getCode() {
        return code;
    }

    public EntityNotFound(String message) {
        super(message);
    }

    public EntityNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFound(Throwable cause) {
        super(cause);
    }

    public EntityNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EntityNotFound() {
        super();
    }


}
