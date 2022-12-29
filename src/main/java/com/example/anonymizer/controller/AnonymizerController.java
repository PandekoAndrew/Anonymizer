package com.example.anonymizer.controller;


import com.example.anonymizer.model.OutputDTO;
import com.example.anonymizer.service.AnonymizerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnonymizerController {

    private final AnonymizerService anonymizerService;

    @Autowired
    public AnonymizerController(AnonymizerService anonymizerService) {
        this.anonymizerService = anonymizerService;
    }

    @PostMapping(path = "/anonymize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutputDTO> anonymize(@RequestBody String input) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(input);

        String output = anonymizerService.anonymize(jsonNode.get("input").asText());
        return ResponseEntity.ok(new OutputDTO(output));
    }
}
