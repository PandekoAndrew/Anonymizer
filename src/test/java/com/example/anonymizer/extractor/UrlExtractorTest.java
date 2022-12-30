package com.example.anonymizer.extractor;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlExtractorTest extends AbstactTest {
    private UrlExtractor extractor;


    @BeforeEach
    void setUp() {
        extractor = new UrlExtractor();
    }

    @Test
    void extract() {
        Set<String> result = extractor.extract(INPUT);
        assertEquals(Set.of("https://google.com"), result);
    }

}