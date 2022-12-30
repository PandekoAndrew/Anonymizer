package com.example.anonymizer.generator;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompanyGeneratorTest {

    private CompanyGenerator generator;

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = mock(Faker.class, invocation -> {
            Company company = mock(Company.class);
            when(company.name()).thenReturn("iTechArt");
            return company;
        });
        generator = new CompanyGenerator();
        generator.setFaker(faker);
    }

    @Test
    void generate() {
        String result = generator.generate();
        assertEquals("iTechArt", result);
    }
}