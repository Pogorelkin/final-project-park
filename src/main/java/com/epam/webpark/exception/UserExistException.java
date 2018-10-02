package com.epam.webpark.exception;

public class UserExistException extends RuntimeException {
    public UserExistException() {
        super("Error. User with this login already exists");
    }
}
