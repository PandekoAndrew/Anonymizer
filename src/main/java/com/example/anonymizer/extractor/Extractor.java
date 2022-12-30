package com.example.anonymizer.extractor;

import java.util.Set;

/**
 * Interface that provides extraction of strings from given text
 */
public interface Extractor {
    Set<String> extract(String input);
}
