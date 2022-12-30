package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IdGeneratorTest {
    private IdGenerator generator;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Number number = mock(Number.class);
            when(number.numberBetween(1000, 99999999)).thenReturn(12345678);
            return number;
        });
        generator = new IdGenerator();
        generator.setFaker(faker);
    }

    @Test
    void testGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("12345678", result);
    }
}