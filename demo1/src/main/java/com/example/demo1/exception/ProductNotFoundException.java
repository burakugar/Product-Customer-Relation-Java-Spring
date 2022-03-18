package com.example.demo1.exception;

import com.example.demo1.constants.ErrorCodes;

public class ProductNotFoundException extends RuntimeException{
    private final int code;

    public ProductNotFoundException() {
        super("No product found with given id!");
        this.code = ErrorCodes.PRODUCT_BY_ID_NOT_FOUND;
    }
}
