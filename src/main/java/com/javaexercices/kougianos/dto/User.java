package com.javaexercices.kougianos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateInserted;
}
