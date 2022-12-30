package com.example.anonymizer.extractor;

import org.springframework.stereotype.Component;

/**
 * Extracts domain names
 */
@Component
public class DomainExtractor extends RegexExtractor {

    public DomainExtractor() {
        this.regex = "(?<=https?:\\/\\/)([\\w_-]+(?:(?:\\.[\\w_-]+)+))";
    }

}
