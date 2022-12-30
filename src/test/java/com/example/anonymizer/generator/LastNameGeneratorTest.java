package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LastNameGeneratorTest {
    private LastNameGenerator generator;

    private Faker faker;

    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.lastName()).thenReturn("White");
            return name;
        });
        generator = new LastNameGenerator();
        generator.setFaker(faker);
    }

    void setUpEmpty() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.lastName()).thenReturn("");
            return name;
        });
        generator = new LastNameGenerator();
        generator.setFaker(faker);
    }

    void setUpNull() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.lastName()).thenReturn(null);
            return name;
        });
        generator = new LastNameGenerator();
        generator.setFaker(faker);
    }

    @Test
    void TestGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("White", result);
    }

    @Test
    void TestGenerateEmpty() {
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