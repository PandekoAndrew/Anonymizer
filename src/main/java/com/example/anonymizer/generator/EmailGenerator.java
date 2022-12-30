package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generate a random email
 */
@Component
public class EmailGenerator extends Generator {
    @Override
    public String generate() {
        return faker.internet().safeEmailAddress();
    }
}
