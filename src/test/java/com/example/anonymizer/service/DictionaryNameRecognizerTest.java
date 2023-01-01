package com.example.anonymizer.service;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryNameRecognizerTest extends AbstactTest {

    private DictionaryNameRecognizer nameRecognizer = new DictionaryNameRecognizer(RECOGNIZED_NAMES);
    @Test
    void testRecognizeNamesSuccess() {
        assertEquals(RECOGNIZED_NAMES, nameRecognizer.recognizeNames(INPUT));
    }
}