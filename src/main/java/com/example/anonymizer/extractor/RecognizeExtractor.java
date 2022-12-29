package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;

import java.util.Set;

public abstract class RecognizeExtractor implements Extractor {
    protected String key;
    protected NameRecognizer nameRecognizer;

    @Override
    public Set<String> extract(String input) {
        return nameRecognizer.recognizeNames(input).get(key);
    }
}
