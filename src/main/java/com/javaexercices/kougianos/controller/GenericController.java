package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.dto.PropertiesDto;
import com.javaexercices.kougianos.dto.bank.DetailsType;
import com.javaexercices.kougianos.dto.bank.GetBankResponseType;
import com.javaexercices.kougianos.dto.bank.GetBankType;
import com.javaexercices.kougianos.dto.bank.ObjectFactory;
import com.javaexercices.kougianos.service.BankService;
import com.javaexercices.kougianos.service.MongoService;
import com.javaexercices.kougianos.util.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "")
@Slf4j
public class GenericController {

    private MongoService mongoService;
    private final BankService bankService;
    private final PropertiesDto propertiesDto;
    private final PropertiesDto propertiesDtoCustom;

    @Autowired(required = false)
    public GenericController(MongoService mongoService, BankService bankService,
                             PropertiesDto propertiesDto,
                             @Qualifier("propertiesDtoCustom") PropertiesDto propertiesDtoCustom) {
        this.mongoService = mongoService;
        this.bankService = bankService;
        this.propertiesDto = propertiesDto;
        this.propertiesDtoCustom = propertiesDtoCustom;
    }

    @Autowired(required = false)
    public GenericController(BankService bankService, PropertiesDto propertiesDto,
                             @Qualifier("propertiesDtoCustom") PropertiesDto propertiesDtoCustom) {
        this.bankService = bankService;
        this.propertiesDto = propertiesDto;
        this.propertiesDtoCustom = propertiesDtoCustom;
    }

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
        GetBankResponseType response = bankService.getBank(objectFactory.createGetBank(type));
        return response.getDetails();
    }

    // http://localhost:8080/test/getProperties/0
    @GetMapping(path = "/test/getProperties/{selection}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    String getProperties(@PathVariable("selection") int selection) {
        return selection == 0 ? this.propertiesDto.toString() : this.propertiesDtoCustom.toString();
    }
}
