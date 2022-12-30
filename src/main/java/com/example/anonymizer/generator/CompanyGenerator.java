package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

/**
 * Generates random company name
 */
public class CompanyGenerator implements Generator{
    @Override
    public String generate() {
        return new Faker().company().name();
    }
}
