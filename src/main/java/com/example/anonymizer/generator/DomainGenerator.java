package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

/**
 * Generates a random domain name
 */
public class DomainGenerator implements Generator {
    @Override
    public String generate() {
        return new Faker().internet().domainName();
    }
}
