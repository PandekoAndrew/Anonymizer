package com.example.anonymizer.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class FakeValuesGenerator {

    private final Faker faker;

    public FakeValuesGenerator() {
        this.faker = new Faker();
    }

    public String generateEmail(){
        return faker.internet().safeEmailAddress();
    }

    public String generateURL(){
        return faker.internet().url();
    }

    public String generateFirstName(){
        return faker.name().firstName();
    }

    public String generateLastName(){
        return faker.name().lastName();
    }

    public String generateCompanyName(){
        return faker.company().name();
    }

    public String generateID(){
        return String.valueOf(faker.number().numberBetween(1000, 99999999));
    }
}
