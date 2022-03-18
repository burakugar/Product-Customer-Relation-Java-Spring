package com.example.demo1.exception;

import com.example.demo1.constants.ErrorCodes;

public class CustomerNotFoundException extends RuntimeException {

    private final int code;

    public CustomerNotFoundException() {
        super("No customer found with given id!\"");
        this.code = ErrorCodes.CUSTOMER_BY_ID_NOT_FOUND;
    }

}
