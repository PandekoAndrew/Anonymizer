package com.example.anonymizer.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CompanyGeneratorTest {

    private CompanyGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new CompanyGenerator();
    }

    @Test
    void generate() {
        assertFalse(generator.generate().isEmpty());
    }
}