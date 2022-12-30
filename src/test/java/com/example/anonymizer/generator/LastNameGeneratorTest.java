package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LastNameGeneratorTest {
    private LastNameGenerator generator;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.lastName()).thenReturn("White");
            return name;
        });
        generator = new LastNameGenerator();
        generator.setFaker(faker);
    }

    @Test
    void generate() {
        String result = generator.generate();
        assertEquals("White", result);
    }
}