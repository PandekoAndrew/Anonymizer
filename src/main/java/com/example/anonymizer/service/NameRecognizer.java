package com.example.anonymizer.service;

import java.util.Map;
import java.util.Set;

/**
 * Interface that provides names recognition in given text
 */
public interface NameRecognizer {

    Map<String, Set<String>> recognizeNames(String input);
}
