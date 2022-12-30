package com.example.anonymizer.model;

import com.example.anonymizer.extractor.Extractor;
import com.example.anonymizer.generator.Generator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

/**
 * Class that contains related pair of extractor and generator
 * and use them to anonymize text
 */
@AllArgsConstructor
@Getter
public class Anonymizer {
    private final Extractor extractor;
    private final Generator generator;

    /**
     * Method that anonymize input by extracting strings and replacing them with newly generated values
     *
     * @param input text to be anonymized
     * @return anonymized text
     */
    public String anonymize(String input) {
        Set<String> extractedSet = extractor.extract(input);

        for (String s : extractedSet) {
            input = input.replace(s, generator.generate());
        }
        return input;
    }
}
