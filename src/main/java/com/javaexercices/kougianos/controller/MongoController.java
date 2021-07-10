package com.javaexercices.kougianos.controller;

import com.javaexercices.kougianos.dto.User;
import com.javaexercices.kougianos.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "mongo")
@Slf4j
@ConditionalOnProperty(
        value = "mongo.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class MongoController {
    //TODO
    private final MongoService mongoService;

    @Autowired
    public MongoController(MongoService mongoService) {
        this.mongoService = mongoService;
    }

    // test url POST http://localhost:8080/mongo/users/create
    @PostMapping(path = "/users/create", consumes = "application/json", produces = "text/plain")
    @ResponseStatus(value = HttpStatus.OK)
    public String createUser(@RequestBody @Valid User user) {
        return mongoService.createUser(user);
    }
}
