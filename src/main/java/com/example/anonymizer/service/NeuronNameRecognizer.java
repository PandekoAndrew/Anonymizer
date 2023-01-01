package com.example.anonymizer.service;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Service that recognize names using named entity recognition algorithm
 */
@Service
public class NeuronNameRecognizer extends NameRecognizer {

    public NeuronNameRecognizer() {
        recognizedNames = new HashMap<>();
        recognizedNames.put("fname", new HashSet<>());
        recognizedNames.put("lname", new HashSet<>());
        recognizedNames.put("company", new HashSet<>());
    }

    public Map<String, Set<String>> recognizeNames(String input) {

        input = prepareForAnalysis(input);
        // Tokenise sentences
        try {
            InputStream inputStreamTokenizer = new FileInputStream("src/main/resources/opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin");
            TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
            TokenizerME tokenizer = new TokenizerME(tokenModel);
            String[] tokens = tokenizer.tokenize(input);
            //Load the model
            InputStream inputStream = new FileInputStream("src/main/resources/ner-custom-model.bin");
            TokenNameFinderModel model;

            model = new TokenNameFinderModel(inputStream);

            NameFinderME nameFinder = new NameFinderME(model);
            Span nameSpans[] = nameFinder.find(tokens);
            for (Span name : nameSpans) {
                String entity = "";
                for (int i = name.getStart(); i < name.getEnd(); i++) {
                    entity += tokens[i] + " ";
                }
                entity = entity.trim();
                recognizedNames.get(name.getType()).add(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recognizedNames;
    }

    private String prepareForAnalysis(String input) {
        input = input.replaceAll("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", "");
        input = input.replaceAll("[^a-zA-Z ]+", " ");
        input = input.replaceAll("\\b\\w{1,2}\\b", "");
        return input;
    }
}
