package com.example.demo.domain;

public class ExceptionMessage {

    private String message;

    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
