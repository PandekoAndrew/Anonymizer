package com.example.anonymizer.extractor;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainExtractorTest extends AbstactTest {
    private DomainExtractor extractor;


    @BeforeEach
    void setUp() {
        extractor = new DomainExtractor();
    }

    @Test
    void extract() {
        Set<String> result = extractor.extract(INPUT);
        assertEquals(Set.of("google.com"), result);
    }

}