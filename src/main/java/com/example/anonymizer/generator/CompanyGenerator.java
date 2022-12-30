package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generates random company name
 */
@Component
public class CompanyGenerator extends Generator {
    @Override
    public String generate() {
        return faker.company().name();
    }
}
