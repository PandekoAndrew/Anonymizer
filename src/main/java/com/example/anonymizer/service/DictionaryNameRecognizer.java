package com.example.anonymizer.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Service that recognize names using dictionary
 */
public class DictionaryNameRecognizer implements NameRecognizer {

    @Value("#{${dictionary}}")
    private Map<String, Set<String>> recognizedNames = new HashMap<String, Set<String>>();

    @Override
    public Map<String, Set<String>> recognizeNames(String input) {
        return recognizedNames;
    }
}
