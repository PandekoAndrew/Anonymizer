package com.example.anonymizer.service;

import java.util.Map;
import java.util.Set;

/**
 * Interface that provides names recognition in given text
 */
public abstract class NameRecognizer {

    protected Map<String, Set<String>> recognizedNames;

    public abstract Map<String, Set<String>> recognizeNames(String input);
}
