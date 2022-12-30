package com.example.anonymizer.extractor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract class for extractors based on regular expressions
 */
public abstract class RegexExtractor implements Extractor {
    protected String regex;

    /**
     * Extracts strings from given text using {@link regex}
     *
     * @param input text in which strings are to be extracted
     * @return set of strings to be extracted
     */
    @Override
    public Set<String> extract(String input) {
        Set<String> result = new HashSet<>();

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }
}
