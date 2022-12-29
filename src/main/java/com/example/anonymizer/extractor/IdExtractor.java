package com.example.anonymizer.extractor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdExtractor implements Extractor {
    @Override
    public Set<String> extract(String input) {
        Set<String> result = new HashSet<>();

        String regex = "\\d{4,}";

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }
}
