package com.example.anonymizer.service;

import java.util.Map;
import java.util.Set;

public interface NameRecognizer {

    Map<String, Set<String>> recognizeNames(String input);
}
