package com.example.anonymizer.service;

import com.example.anonymizer.extractor.*;
import com.example.anonymizer.generator.*;
import com.example.anonymizer.model.Anonymizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnonymizerService {

    private List<Anonymizer> anonymizers;

    public AnonymizerService(@Qualifier("dictionaryNameRecognizer") NameRecognizer nameRecognizer) {
        this.anonymizers = new ArrayList<>();
        anonymizers.add(new Anonymizer(new IdExtractor(), new IdGenerator()));
        anonymizers.add(new Anonymizer(new UrlExtractor(), new UrlGenerator()));
        anonymizers.add(new Anonymizer(new EmailExtractor(), new EmailGenerator()));
        anonymizers.add(new Anonymizer(new FirstNameExtractor(nameRecognizer), new FirstNameGenerator()));
        anonymizers.add(new Anonymizer(new LastNameExtractor(nameRecognizer), new LastNameGenerator()));
        anonymizers.add(new Anonymizer(new CompanyExtractor(nameRecognizer), new CompanyGenerator()));

    }

    public String anonymize(String input) {
        for (Anonymizer a : anonymizers) {
            input = a.anonymize(input);
        }

        return input;
    }
}
