package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

public class LastNameGenerator implements Generator{
    @Override
    public String generate() {
        return new Faker().name().lastName();
    }
}
