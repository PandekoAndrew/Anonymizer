package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FirstNameGeneratorTest {
    private FirstNameGenerator generator;

    private Faker faker;


    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.firstName()).thenReturn("Wolter");
            return name;
        });
        generator = new FirstNameGenerator();
        generator.setFaker(faker);
    }


    void setUpEmpty() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.firstName()).thenReturn("");
            return name;
        });
        generator = new FirstNameGenerator();
        generator.setFaker(faker);
    }


    void setUpNull() {
        faker = mock(Faker.class, invocation -> {
            Name name = mock(Name.class);
            when(name.firstName()).thenReturn(null);
            return name;
        });
        generator = new FirstNameGenerator();
        generator.setFaker(faker);
    }

    @Test
    void TestGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("Wolter", result);
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