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
    @Column(value = "name")
    private String name;
    @Column(value = "age")
    private Integer ageInYears;
    @Column(value = "dob")
    private LocalDate dob;
}
