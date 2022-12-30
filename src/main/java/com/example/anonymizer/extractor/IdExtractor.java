package com.example.anonymizer.extractor;

import org.springframework.stereotype.Component;

/**
 * Extracts IDs
 */
@Component
public class IdExtractor extends RegexExtractor {

    public IdExtractor() {
        this.regex = "\\d{4,}";
    }
}
