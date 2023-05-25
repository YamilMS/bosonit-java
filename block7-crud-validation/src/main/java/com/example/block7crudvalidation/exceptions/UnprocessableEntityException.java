package com.example.block7crudvalidation.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class UnprocessableEntityException extends RuntimeException {
    private CustomError customError;

    public UnprocessableEntityException(String message) {
        super(message);
        this.customError = new CustomError(new Date(), 422, message);
    }

}