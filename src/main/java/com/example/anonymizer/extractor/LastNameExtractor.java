package com.example.anonymizer.extractor;

import com.example.anonymizer.service.NameRecognizer;

public class LastNameExtractor extends RecognizeExtractor {

    public LastNameExtractor(NameRecognizer nameRecognizer) {
        this.nameRecognizer = nameRecognizer;
        this.key = "lname";
    }
}
