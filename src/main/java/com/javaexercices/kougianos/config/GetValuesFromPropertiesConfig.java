package com.javaexercices.kougianos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class GetValuesFromPropertiesConfig {

    @Value("${test.string}")
    private String testString;
    @Value("${test.number}")
    private int testNumber;
    @Value("${test.array}")
    private String[] testStringArray;
    // Split is better because it returns an ArrayList, without split it returns UnmodifiableRandomAccessList
    @Value("#{'${test.array}'.split(',')}")
    private List<String> testStringListSplit;
    @Value("#{${test.listOfStrings}}")
    private List<String> testStringList;
    @Value("${test.boolean}")
    private boolean testBoolean;

    @Bean(name = "injectedApplicationProperties")
    @Primary
    public Map<String, Object> injectedApplicationProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("String", testString);
        map.put("Number", testNumber);
        map.put("Array", testStringArray);
        map.put("ListSplit", testStringListSplit);
        map.put("List", testStringList);
        map.put("Boolean", testBoolean);
        return map;
    }
}
