package com.javaexercices.kougianos.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

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

}
