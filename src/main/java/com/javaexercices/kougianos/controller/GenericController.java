package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.util.ConvertUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")
public class GenericController {

    @PostMapping(path = "/convert/XmlToJson", consumes = "application/xml", produces = "application/json")
    public String convertXmlToJson(@RequestBody String xmlString) {
        return ConvertUtils.xmlToJsonString(xmlString);
    }

    @PostMapping(path = "/convert/JsonToXml", consumes = "application/json", produces = "application/xml")
    public String convertJsonToXml(@RequestBody String jsonString) {
        return ConvertUtils.jsonToXmlString(jsonString);
    }

}
