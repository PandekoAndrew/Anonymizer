package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmailGeneratorTest {
    private EmailGenerator generator;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.safeEmailAddress()).thenReturn("foo@gmail.com");
            return internet;
        });
        generator = new EmailGenerator();
        generator.setFaker(faker);
    }

    @Test
    void generate() {
        String result = generator.generate();
        assertEquals("foo@gmail.com", result);
    }
}