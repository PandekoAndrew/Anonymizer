package com.example.anonymizer.generator;

import org.springframework.stereotype.Component;

/**
 * Generates a random domain name
 */
@Component
public class DomainGenerator extends Generator {
    @Override
    public String generate() {
        return faker.internet().domainName();
    }
}
