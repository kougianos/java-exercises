package com.javaexercices.kougianos.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertiesDto {
    private String testString;
    private int testNumber;
    private String[] testStringArray;
    private List<String> testStringListSplit;
    private List<String> testStringList;
    private boolean testBoolean;
}
