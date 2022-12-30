package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generates a random last name
 */
@Component
public class LastNameGenerator extends Generator {
    @Override
    public String generate() {
        return faker.name().lastName();
    }
}
