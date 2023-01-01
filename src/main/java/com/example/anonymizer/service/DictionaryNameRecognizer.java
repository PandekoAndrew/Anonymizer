package com.example.anonymizer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Service that recognize names using dictionary
 */
@Service
public class DictionaryNameRecognizer extends NameRecognizer {

    public DictionaryNameRecognizer(@Value("#{${dictionary}}") Map<String, Set<String>> recognizedNames) {
        this.recognizedNames = recognizedNames;
    }

    @Override
    public Map<String, Set<String>> recognizeNames(String input) {
        return recognizedNames;
    }
}
