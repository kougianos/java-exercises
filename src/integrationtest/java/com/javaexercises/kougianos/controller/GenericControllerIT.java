package com.javaexercises.kougianos.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexercices.kougianos.KougianosApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = KougianosApplication.class)
@AutoConfigureMockMvc
class GenericControllerIT {

    /**
     * Invokes generic controller jsonToXML endpoint, and asserts results.
     *
     * @param mvc MockMvc object
     * @throws Exception any exceptions that this test may throw.
     */
    @Test
    void testJsonToXml(@Autowired MockMvc mvc) throws Exception {

        String jsonRequest = "{'test': 123}";

        mvc.perform(
                post("/convert/JsonToXml")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "application/xml;charset=UTF-8"));

        mvc.perform(
                post("/convert/JsonToXml")
                        .contentType(MediaType.APPLICATION_XML)
                        .content(jsonRequest))
                .andExpect(status().is(415))
                .andExpect(header().string("Accept", "application/json"));

    }

    /**
     * Invokes generic controller getMongoCollections endpoint, and asserts results.
     *
     * @param mvc MockMvc object
     * @param mapper ObjectMapper
     * @throws Exception any exceptions that this test may throw.
     */
    @Test
    void testMongoCollections(@Autowired MockMvc mvc, @Autowired ObjectMapper mapper) throws Exception {

        MvcResult result = mvc.perform(
                get("/test/getMongoCollections")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode json = mapper.readTree(result.getResponse().getContentAsString());
        assertEquals(2, json.size());

    }

}
