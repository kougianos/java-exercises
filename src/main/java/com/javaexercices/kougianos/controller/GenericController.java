package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.dto.soap.DetailsType;
import com.javaexercices.kougianos.dto.soap.GetBankResponseType;
import com.javaexercices.kougianos.dto.soap.GetBankType;
import com.javaexercices.kougianos.dto.soap.ObjectFactory;
import com.javaexercices.kougianos.service.MongoService;
import com.javaexercices.kougianos.service.SoapClient;
import com.javaexercices.kougianos.util.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(force = true)
@Slf4j
public class GenericController {

    private final MongoService mongoService;
    private final SoapClient soapClient;

    @PostMapping(path = "/convert/XmlToJson", consumes = "application/xml", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    String convertXmlToJson(@RequestBody String xmlString) {
        return ConvertUtils.xmlToJsonString(xmlString);
    }

    @PostMapping(path = "/convert/JsonToXml", consumes = "application/json", produces = "application/xml")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    String convertJsonToXml(@RequestBody String jsonString) {
        return ConvertUtils.jsonToXmlString(jsonString);
    }

    // test url GET http://localhost:8080/test/getMongoCollections
    @GetMapping(path = "/test/getMongoCollections", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Set<String> getAllMongoCollections() {
        return mongoService.getAllMongoCollections();
    }

    // test url GET http://localhost:8080/test/getBankDetails?code=46062817
    // example codes 46062817 21830035 87069077 35090300
    @GetMapping(path = "/test/getBankDetails", produces = "application/xml")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    DetailsType getBankDetails(@RequestParam String code) {
        log.info("getBankDetails for code {}", code);
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(code);
        GetBankResponseType response = soapClient.getBank(objectFactory.createGetBank(type));
        return response.getDetails();
    }
}
