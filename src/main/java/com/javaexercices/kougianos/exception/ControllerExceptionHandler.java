package com.javaexercices.kougianos.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * Exception handler for validation of User Pojo Fields.
     * @param ex exception
     * @return Error
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Error error = new Error(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(ZoneId.of("Europe/Athens")),
                "MethodArgumentNotValidException",
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        log.error("MethodArgumentNotValidException for body {}", ex.getBindingResult().getTarget());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for illegal argument exceptions.
     * @param ex exception
     * @return Error
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException ex) {
        Error error = new Error(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(ZoneId.of("Europe/Athens")),
                "IllegalArgumentException",
                ex.getMessage());
        log.error("IllegalArgumentException", ex);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for illegal argument exceptions.
     * @param ex exception
     * @return Error
     */
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Error> handleDateTimeParseException(DateTimeParseException ex) {
        Error error = new Error(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(ZoneId.of("Europe/Athens")),
                "DateTimeParseException",
                ex.getMessage());
        log.error("DateTimeParseException", ex);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
