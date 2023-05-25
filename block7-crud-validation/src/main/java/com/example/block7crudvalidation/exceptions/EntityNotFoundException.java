package com.example.block7crudvalidation.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class EntityNotFoundException extends RuntimeException {
    private CustomError customError;

    public EntityNotFoundException(String message) {
        super(message);
        this.customError = new CustomError(new Date(), 404, message);
    }

}
