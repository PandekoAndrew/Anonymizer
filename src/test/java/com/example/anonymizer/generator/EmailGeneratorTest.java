package com.example.anonymizer.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailGeneratorTest {
    private EmailGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new EmailGenerator();
    }

    @Test
    void generate() {
        assertNotNull(generator.generate());
    }
}