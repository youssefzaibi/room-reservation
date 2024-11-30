package com.example.roomreservation.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException (String message) {
        super(message);
    }
}
