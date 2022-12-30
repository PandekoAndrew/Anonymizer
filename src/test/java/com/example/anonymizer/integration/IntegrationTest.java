package com.example.anonymizer.integration;

import com.example.anonymizer.AbstactTest;
import com.example.anonymizer.AnonymizerApplication;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AnonymizerApplication.class)
@AutoConfigureMockMvc
public class IntegrationTest extends AbstactTest {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void TestAnonymizeOk() throws Exception {

        JsonNode input = objectMapper.readTree(String.format("{\"input\" : \"%s\"}", INPUT));

        mvc.perform(MockMvcRequestBuilders
                        .post("/anonymize")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writer().writeValueAsString(input))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output").exists())
                .andExpect(jsonPath("$.output").isNotEmpty());
    }

    @Test
    void TestAnonymizeUnsupported() throws Exception {

        JsonNode input = objectMapper.readTree(String.format("{\"input\" : \"%s\"}", INPUT));

        mvc.perform(MockMvcRequestBuilders
                        .post("/anonymize")
                        .content(objectMapper.writer().writeValueAsString(input))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(415));
    }
}
