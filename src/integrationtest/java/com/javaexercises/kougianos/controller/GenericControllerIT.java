package com.javaexercises.kougianos.controller;

import com.javaexercices.kougianos.KougianosApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = KougianosApplication.class)
@AutoConfigureMockMvc
class GenericControllerIT {

    /**
     * Integration test that invokes one generic controller endpoint, and asserts results.
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

}
