package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class FirstNameExtractor implements Extractor{
    private final NameRecognizer nameRecognizer;

    @Override
    public Set<String> extract(String input) {
        return nameRecognizer.recognizeNames(input).get("fname");
    }
}
