package com.javaexercices.kougianos.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Error entity.
 */
@Data
@AllArgsConstructor
public class Error {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;
}
