package com.example.anonymizer.extractor;

import java.util.Set;

public interface Extractor {
    Set<String> extract(String input);
}
