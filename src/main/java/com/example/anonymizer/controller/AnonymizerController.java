package com.example.anonymizer.controller;


import com.example.anonymizer.dto.OutputDTO;
import com.example.anonymizer.service.AnonymizerService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AnonymizerController {

    private final AnonymizerService anonymizerService;

    @PostMapping(path = "/anonymize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutputDTO> anonymize(@RequestBody JsonNode input) {
        String output = anonymizerService.anonymize(input.get("input").asText());
        return ResponseEntity.ok(new OutputDTO(output));
    }
}
