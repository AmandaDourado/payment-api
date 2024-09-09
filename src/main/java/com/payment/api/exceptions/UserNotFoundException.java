package com.payment.api.exceptions;

public class UserNotFoundException extends  RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }
}
