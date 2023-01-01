package com.example.anonymizer.config;

import com.example.anonymizer.extractor.Extractor;
import com.example.anonymizer.generator.Generator;
import com.example.anonymizer.model.Anonymizer;
import com.example.anonymizer.service.NameRecognizer;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Initialize beans on application startup
 */
@Configuration
public class BeanConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public Anonymizer idAnonymizer(@Qualifier("idExtractor") Extractor extractor,
                                   @Qualifier("idGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public Anonymizer domainAnonymizer(@Qualifier("domainExtractor") Extractor extractor,
                                       @Qualifier("domainGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public Anonymizer emailAnonymizer(@Qualifier("emailExtractor") Extractor extractor,
                                      @Qualifier("emailGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public Anonymizer firstNameAnonymizer(@Qualifier("firstNameExtractor") Extractor extractor,
                                          @Qualifier("firstNameGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public Anonymizer lastNameAnonymizer(@Qualifier("lastNameExtractor") Extractor extractor,
                                         @Qualifier("lastNameGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public Anonymizer companyAnonymizer(@Qualifier("companyExtractor") Extractor extractor,
                                        @Qualifier("companyGenerator") Generator generator) {
        return new Anonymizer(extractor, generator);
    }

    @Bean
    public NameRecognizer nameRecognizer(@Qualifier("dictionaryNameRecognizer") NameRecognizer nameRecognizer) {
        return nameRecognizer;
    }
}
