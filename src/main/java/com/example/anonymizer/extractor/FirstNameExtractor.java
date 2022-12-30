package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;
import org.springframework.stereotype.Component;


/**
 * Extracts first names
 */
@Component
public class FirstNameExtractor extends RecognizeExtractor {
    public FirstNameExtractor(NameRecognizer nameRecognizer) {
        this.nameRecognizer = nameRecognizer;
        this.key = "fname";
    }
}
