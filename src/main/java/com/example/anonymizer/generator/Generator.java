package com.example.anonymizer.generator;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class that provides text generation
 */
public abstract class Generator {
    protected Faker faker;

    @Autowired
    public final void setFaker(Faker faker) {
        this.faker = faker;
    }

    public abstract String generate();
}
