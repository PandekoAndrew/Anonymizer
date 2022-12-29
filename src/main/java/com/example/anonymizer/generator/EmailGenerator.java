package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

public class EmailGenerator implements Generator{
    @Override
    public String generate() {
        return new Faker().internet().safeEmailAddress();
    }
}
