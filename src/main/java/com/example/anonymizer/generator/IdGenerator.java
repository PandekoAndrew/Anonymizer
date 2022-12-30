package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generates a random ID in 1000-99999999 range
 */
@Component
public class IdGenerator extends Generator {

    @Override
    public String generate() {
        return String.valueOf(faker.number().numberBetween(1000, 99999999));
    }
}
