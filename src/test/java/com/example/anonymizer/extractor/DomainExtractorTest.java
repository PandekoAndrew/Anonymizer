package com.example.anonymizer.extractor;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DomainExtractorTest extends AbstactTest {
    private DomainExtractor extractor;


    @BeforeEach
    void setUp() {
        extractor = new DomainExtractor();
    }

    @Test
    void TestExtractSuccess() {
        Set<String> result = extractor.extract(INPUT);
        assertEquals(Set.of("google.com"), result);
    }

    @Test
    void TestExtractNullPointer() {
        assertThrows(NullPointerException.class, () -> {
            extractor.extract(null);
        });
    }

}