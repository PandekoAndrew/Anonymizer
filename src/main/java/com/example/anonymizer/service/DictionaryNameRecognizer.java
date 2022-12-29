package com.example.anonymizer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DictionaryNameRecognizer implements NameRecognizer{

    @Value("${firstNames}")
    private Set<String> firstNames;
    @Value("${lastNames}")
    private Set<String> lastNames;
    @Value("${companyNames}")
    private Set<String> companyNames;

    @Override
    public Map<String, Set<String>> recognizeNames(String input) {
        Map<String, Set<String>> result= new HashMap<>();
        result.put("fname", firstNames);
        result.put("lname", lastNames);
        result.put("company", companyNames);
        return result;
    }
}
