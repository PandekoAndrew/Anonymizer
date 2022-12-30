package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generate a random first name
 */
@Component
public class FirstNameGenerator extends Generator {
    @Override
    public String generate() {
        return faker.name().firstName();
    }
}
