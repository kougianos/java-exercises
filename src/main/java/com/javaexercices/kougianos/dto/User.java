package com.javaexercices.kougianos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    //TODO validate fields
    private String id;
    private String username;
    private int age;
    private List<Dog> dogs;
    private LocalDate dob;
    private LocalDateTime dateInserted;
}
