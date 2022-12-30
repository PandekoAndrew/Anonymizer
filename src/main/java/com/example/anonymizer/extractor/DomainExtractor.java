package com.example.anonymizer.extractor;

/**
 * Extracts domain names
 */
public class DomainExtractor extends RegexExtractor {

    public DomainExtractor() {
        this.regex = "(?<=https?:\\/\\/)([\\w_-]+(?:(?:\\.[\\w_-]+)+))";
    }

}
