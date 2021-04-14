package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.util.ConvertUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")
public class GenericController {

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

}
