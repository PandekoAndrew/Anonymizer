package com.example.anonymizer.config;

import com.example.anonymizer.extractor.*;
import com.example.anonymizer.generator.*;
import com.example.anonymizer.model.Anonymizer;
import com.example.anonymizer.service.NameRecognizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Initialize beans on application startup
 */
@Configuration
public class BeanConfig {
    @Bean
    public List<Anonymizer> anonymizers(@Qualifier("dictionaryNameRecognizer") NameRecognizer nameRecognizer) {
        List<Anonymizer> anonymizers = new ArrayList<>();

        anonymizers.add(new Anonymizer(new IdExtractor(), new IdGenerator()));
        anonymizers.add(new Anonymizer(new DomainExtractor(), new DomainGenerator()));
        anonymizers.add(new Anonymizer(new EmailExtractor(), new EmailGenerator()));
        anonymizers.add(new Anonymizer(new FirstNameExtractor(nameRecognizer), new FirstNameGenerator()));
        anonymizers.add(new Anonymizer(new LastNameExtractor(nameRecognizer), new LastNameGenerator()));
        anonymizers.add(new Anonymizer(new CompanyExtractor(nameRecognizer), new CompanyGenerator()));

        return anonymizers;
    }

}
