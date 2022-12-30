package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmailGeneratorTest {
    private EmailGenerator generator;

    private Faker faker;

    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.safeEmailAddress()).thenReturn("foo@gmail.com");
            return internet;
        });
        generator = new EmailGenerator();
        generator.setFaker(faker);
    }

    void setUpEmpty() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.safeEmailAddress()).thenReturn("");
            return internet;
        });
        generator = new EmailGenerator();
        generator.setFaker(faker);
    }

    void setUpNull() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.safeEmailAddress()).thenReturn(null);
            return internet;
        });
        generator = new EmailGenerator();
        generator.setFaker(faker);
    }

    @Test
    void testGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("foo@gmail.com", result);
    }

    @Test
    void testGenerateEmpty() {
        setUpEmpty();
        String result = generator.generate();
        assertTrue(result.isEmpty());
    }

    @Test
    void TestGenerateNull() {
        setUpNull();
        assertNull(generator.generate());
    }
}