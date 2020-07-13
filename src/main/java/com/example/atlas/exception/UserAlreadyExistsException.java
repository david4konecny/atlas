package com.example.atlas.exception;

public class UserAlreadyExistsException extends Throwable {

    public UserAlreadyExistsException(String username) {
        super(String.format("Username %s already exists", username));
    }

}