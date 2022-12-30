package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;
import org.springframework.stereotype.Component;

/**
 * Extracts last names
 */
@Component
public class LastNameExtractor extends RecognizeExtractor {

    public LastNameExtractor(NameRecognizer nameRecognizer) {
        this.nameRecognizer = nameRecognizer;
        this.key = "lname";
    }
}
