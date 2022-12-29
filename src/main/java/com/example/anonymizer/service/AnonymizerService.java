package com.example.anonymizer.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AnonymizerService {
    private final FakeValuesGenerator fakeValuesGenerator;
    private final Extractor extractor;

    public AnonymizerService(FakeValuesGenerator fakeValuesGenerator, Extractor extractor) {
        this.fakeValuesGenerator = fakeValuesGenerator;
        this.extractor = extractor;
    }

    public String anonymize(String input) {
        String result = input;
        Set<String> extractedIDs = extractor.extractIDs(input);

        for(String s : extractedIDs){
            result = result.replace(s, fakeValuesGenerator.generateID());
        }

        Set<String> extractedEmails = extractor.extractEmails(input);

        for(String s : extractedEmails) {
            result = result.replace(s, fakeValuesGenerator.generateEmail());
        }

        Set<String> extractedURLs = extractor.extractURLs(input);

        for(String s : extractedURLs) {
            result = result.replace(s, fakeValuesGenerator.generateURL());
        }

        Set<String> extractedFirstNames = extractor.extractFirstNames(input);

        for(String s : extractedFirstNames) {
            result = result.replace(s, fakeValuesGenerator.generateFirstName());
        }

        Set<String> extractedLastNames = extractor.extractLastNames(input);

        for(String s : extractedLastNames) {
            result = result.replace(s, fakeValuesGenerator.generateLastName());
        }

        Set<String> extractedCompanyNames = extractor.extractCompanyNames(input);

        for(String s : extractedCompanyNames) {
            result = result.replace(s, fakeValuesGenerator.generateCompanyName());
        }

        return result;
    }
}
