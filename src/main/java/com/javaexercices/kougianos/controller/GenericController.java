package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.service.MongoService;
import com.javaexercices.kougianos.service.SoapClient;
import com.javaexercices.kougianos.util.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(force = true)
public class GenericController {

    private final MongoService mongoService;
    @Autowired
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

    @GetMapping(path = "/test/getMongoCollections", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Set<String> getAllMongoCollections() {
        return mongoService.getAllMongoCollections();
    }

    @GetMapping(path = "/test/getBankDetails", produces = "application/xml")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    DetailsType getBankDetails(@RequestParam String code) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz("46062817");
        GetBankResponseType response = soapClient.getBank("http://www.thomas-bayer.com/axis2/services/BLZService", objectFactory.createGetBank(type));
        return new DetailsType();
    }

}
