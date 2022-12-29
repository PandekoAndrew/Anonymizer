package com.example.anonymizer.generator;

import com.github.javafaker.Faker;

public class IdGenerator implements Generator{

    @Override
    public String generate() {
        return String.valueOf(new Faker().number().numberBetween(1000, 99999999));
    }
}
