package com.example.anonymizer.extractor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexExtractor implements Extractor {
    protected String regex;

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
