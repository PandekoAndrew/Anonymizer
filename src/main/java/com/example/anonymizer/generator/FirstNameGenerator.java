package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

public class FirstNameGenerator implements Generator{
    @Override
    public String generate() {
        return new Faker().name().firstName();
    }
}
