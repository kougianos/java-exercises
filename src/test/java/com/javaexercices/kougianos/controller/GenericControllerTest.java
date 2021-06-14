package com.javaexercices.kougianos.controller;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericControllerTest {

    private final GenericController genericController = new GenericController();

    @Test
    void testXmlToJson() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/xmlToJsonRequest.xml"));
        String xmlRequest = reader.lines().collect(Collectors.joining("\n"));

        String actualResponse = genericController.convertXmlToJson(xmlRequest).replaceAll("\\s", "");
        reader = new BufferedReader(new FileReader("src/test/resources/xmlToJsonResponse.json"));
        String jsonResponse = reader.lines().collect(Collectors.joining("\n")).replaceAll("\\s", "");
        assertEquals(jsonResponse, actualResponse);

    }

    @Test
    void testJsonToXml() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/jsonToXmlRequest.json"));
        String jsonRequest = reader.lines().collect(Collectors.joining("\n"));

        String actualResponse = genericController.convertJsonToXml(jsonRequest).replaceAll("\\s", "");
        reader = new BufferedReader(new FileReader("src/test/resources/jsonToXmlResponse.xml"));
        String xmlResponse = reader.lines().collect(Collectors.joining("\n")).replaceAll("\\s", "");
        assertEquals(xmlResponse, actualResponse);

    }

}
