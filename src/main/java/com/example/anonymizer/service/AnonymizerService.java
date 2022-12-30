package com.example.anonymizer.service;

import com.example.anonymizer.model.Anonymizer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that anonymize text using given anonymizers
 */
@Service
public class AnonymizerService {

    private List<Anonymizer> anonymizers;

    public AnonymizerService(List<Anonymizer> anonymizers) {
        this.anonymizers = anonymizers;
    }

    /**
     * @param input text to be anonymized
     * @return anonymized text
     */
    public String anonymize(String input) {
        for (Anonymizer a : anonymizers) {
            input = a.anonymize(input);
        }

        return input;
    }
}
