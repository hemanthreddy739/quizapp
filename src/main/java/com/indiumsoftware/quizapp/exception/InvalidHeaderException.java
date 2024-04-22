package com.indiumsoftware.quizapp.exception;

import java.io.Serial;

public class InvalidHeaderException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;

    public InvalidHeaderException(String message){
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
