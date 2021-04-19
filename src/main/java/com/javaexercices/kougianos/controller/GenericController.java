package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.service.MongoService;
import com.javaexercices.kougianos.util.ConvertUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GenericController {

    private final MongoService mongoService;

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

}
