package com.javaexercices.kougianos.config;

import com.javaexercices.kougianos.dto.PropertiesDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

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

    @Bean(name = "propertiesDto")
    @Primary
    public PropertiesDto propertiesDto() {
        return new PropertiesDto(testString, testNumber, testStringArray,
                testStringListSplit, testStringList, testBoolean);
    }

    @Bean(name = "propertiesDtoCustom")
    public PropertiesDto propertiesDtoCustom() {
        PropertiesDto propertiesDto = new PropertiesDto();
        propertiesDto.setTestString("TEST");
        return propertiesDto;
    }
}
