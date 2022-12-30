package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;


/**
 * Extracts first names
 */
public class FirstNameExtractor extends RecognizeExtractor {
    public FirstNameExtractor(NameRecognizer nameRecognizer) {
        this.nameRecognizer = nameRecognizer;
        this.key = "fname";
    }
}
