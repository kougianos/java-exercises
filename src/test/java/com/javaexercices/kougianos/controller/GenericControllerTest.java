package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.dto.soap.DetailsType;
import com.javaexercices.kougianos.dto.soap.GetBankResponseType;
import com.javaexercices.kougianos.service.BankService;
import com.javaexercices.kougianos.service.MongoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenericControllerTest {

    @Mock
    private MongoService mongoService;
    @Mock
    private BankService bankService;
    private GenericController genericController;

    @BeforeEach
    // Used that way instead of InjectMocks, to clearly inject final fields
    void setUp() {
        genericController = new GenericController(mongoService, bankService);
    }

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
        assertEquals(2, response.size());
    }

    @Test
    void testBankService() {
        DetailsType dt = new DetailsType();
        dt.setPlz("Test");
        GetBankResponseType getBankResponseType = new GetBankResponseType();
        getBankResponseType.setDetails(dt);
        when(bankService.getBank(any())).thenReturn(getBankResponseType);
        var response = genericController.getBankDetails("test");
        assertEquals("Test", response.getPlz());
    }

}
