package com.example.anonymizer.service;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DictionaryNameRecognizerTest extends AbstactTest {

    @Autowired
    private DictionaryNameRecognizer nameRecognizer;

    @Test
    void TestRecognizeNamesSuccess() {
        assertEquals(RECOGNIZED_NAMES, nameRecognizer.recognizeNames(INPUT));
    }
}