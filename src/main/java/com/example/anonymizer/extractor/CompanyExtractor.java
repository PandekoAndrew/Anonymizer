package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;

/**
 * Extracts company names
 */
public class CompanyExtractor extends RecognizeExtractor {
    public CompanyExtractor(NameRecognizer nameRecognizer) {
        this.nameRecognizer = nameRecognizer;
        this.key = "company";
    }
}
