package com.example.anonymizer.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DomainGeneratorTest {
    private DomainGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new DomainGenerator();
    }

    @Test
    void generate() {
        assertNotNull(generator.generate());
    }

}