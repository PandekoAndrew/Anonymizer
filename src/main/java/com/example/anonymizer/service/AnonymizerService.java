package com.example.anonymizer.service;

import com.example.anonymizer.model.Anonymizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnonymizerService {

    private List<Anonymizer> anonymizers;

    public AnonymizerService(List<Anonymizer> anonymizers) {
        this.anonymizers = anonymizers;
    }

    public String anonymize(String input) {
        for (Anonymizer a : anonymizers) {
            input = a.anonymize(input);
        }

        return input;
    }
}
