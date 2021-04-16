package com.javaexercices.kougianos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Dog {
    private String name;
    private Integer ageInYears;
    private LocalDate dob;
}
