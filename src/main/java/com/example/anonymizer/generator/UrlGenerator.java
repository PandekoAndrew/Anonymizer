package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

public class UrlGenerator implements Generator{
    @Override
    public String generate() {
        return new Faker().internet().url();
    }
}
