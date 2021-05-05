package com.javaexercices.kougianos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Table(value = "dogs")
public class Dog {
    @Id
    Long id;
    @Column(value = "NAME")
    private String name;
    @Column(value = "AGE")
    private Integer ageInYears;
    @Column(value = "DOB")
    private LocalDate dob;
}
