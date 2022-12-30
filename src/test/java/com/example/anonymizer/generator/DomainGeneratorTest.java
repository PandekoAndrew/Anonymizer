package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DomainGeneratorTest {
    private DomainGenerator generator;

    private Faker faker;

    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.domainName()).thenReturn("foo.com");
            return internet;
        });
        generator = new DomainGenerator();
        generator.setFaker(faker);
    }

    void setUpEmpty() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.domainName()).thenReturn("");
            return internet;
        });
        generator = new DomainGenerator();
        generator.setFaker(faker);
    }

    void setUpNull() {
        faker = mock(Faker.class, invocation -> {
            Internet internet = mock(Internet.class);
            when(internet.domainName()).thenReturn(null);
            return internet;
        });
        generator = new DomainGenerator();
        generator.setFaker(faker);
    }

    @Test
    void testGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("foo.com", result);
    }

    @Test
    void testGenerateEmpty() {
        setUpEmpty();
        String result = generator.generate();
        assertTrue(result.isEmpty());
    }

    @Test
    void testGenerateNull() {
        setUpNull();
        assertNull(generator.generate());
    }

}