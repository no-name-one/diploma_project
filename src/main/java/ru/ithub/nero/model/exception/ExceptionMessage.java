package ru.ithub.nero.model.exception;

import io.micronaut.http.HttpStatus;

public enum ExceptionMessage {
    ALREADY_EXIST_WITH_USERNAME(HttpStatus.BAD_REQUEST, "User already exist with username"),
    NOT_FOUND_WITH_USERNAME(HttpStatus.NOT_FOUND, "User not found with username"),
    NOT_FOUND_WITH_ID(HttpStatus.NOT_FOUND, "User not found with id");

    private HttpStatus httpStatus;
    private String exceptionMessage;

    ExceptionMessage(HttpStatus httpStatus, String exceptionMessage) {
        this.httpStatus = httpStatus;
        this.exceptionMessage = exceptionMessage;
    }
}
