package com.example.anonymizer.generator;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompanyGeneratorTest {

    private CompanyGenerator generator;

    private Faker faker;

    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Company company = mock(Company.class);
            when(company.name()).thenReturn("iTechArt");
            return company;
        });
        generator = new CompanyGenerator();
        generator.setFaker(faker);
    }

    void setUpEmpty() {
        faker = mock(Faker.class, invocation -> {
            Company company = mock(Company.class);
            when(company.name()).thenReturn("");
            return company;
        });
        generator = new CompanyGenerator();
        generator.setFaker(faker);
    }

    void setUpNull() {
        faker = mock(Faker.class, invocation -> {
            Company company = mock(Company.class);
            when(company.name()).thenReturn(null);
            return company;
        });
        generator = new CompanyGenerator();
        generator.setFaker(faker);
    }


    @Test
    void TestGenerateSuccess() {
        setUp();
        String result = generator.generate();
        assertEquals("iTechArt", result);
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