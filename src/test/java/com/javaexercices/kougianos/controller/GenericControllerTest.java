package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.service.BankService;
import com.javaexercices.kougianos.service.MongoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class GenericControllerTest {

    // TODO fix

    @Mock
    private MongoService mongoService;
    @Mock
    private BankService bankService;
    @InjectMocks
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

    @Test
    void testMongo() {
        when(mongoService.getAllMongoCollections()).thenReturn(Set.of("Collection1", "Collection2"));

        var response = genericController.getAllMongoCollections();

    }

}
