package com.example.anonymizer.extractor;

public class IdExtractor extends RegexExtractor {

    public IdExtractor() {
        this.regex = "\\d{4,}";
    }
}
