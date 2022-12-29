package com.example.anonymizer.model;

import com.example.anonymizer.extractor.Extractor;
import com.example.anonymizer.generator.Generator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class Anonymizer {
    private final Extractor extractor;
    private final Generator generator;

    public String anonymize(String input){
        Set<String> extractedSet = extractor.extract(input);

        for(String s : extractedSet){
            input = input.replace(s, generator.generate());
        }
        return input;
    }
}
