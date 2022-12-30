package com.example.anonymizer.extractor;

import com.example.anonymizer.AbstactTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailExtractorTest extends AbstactTest {
    private EmailExtractor extractor;


    @BeforeEach
    void setUp() {
        extractor = new EmailExtractor();
    }

    @Test
    void TestExtractSuccess() {
        Set<String> result = extractor.extract(INPUT);
        assertEquals(Set.of("pandzeka.andrei@itechart-group.com"), result);
    }

    @Test
    void TestExtractNullPointer() {
        assertThrows(NullPointerException.class, () -> {
            extractor.extract(null);
        });
    }
}