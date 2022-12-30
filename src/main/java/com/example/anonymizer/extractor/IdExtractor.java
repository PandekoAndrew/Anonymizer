package com.example.anonymizer.extractor;

/**
 * Extracts IDs
 */
public class IdExtractor extends RegexExtractor {

    public IdExtractor() {
        this.regex = "\\d{4,}";
    }
}
