package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;

import java.util.Set;

/**
 * Abstract class for extractors based on recognition
 */
public abstract class RecognizeExtractor implements Extractor {
    protected String key;
    protected NameRecognizer nameRecognizer;

    /**
     * Recognize names with type {@link key} in given text
     *
     * @param input text in which names are to be recognized
     * @return set of recognized names
     */
    @Override
    public Set<String> extract(String input) {
        return nameRecognizer.recognizeNames(input).get(key);
    }
}
