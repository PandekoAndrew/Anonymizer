package com.example.anonymizer.extractor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor implements Extractor {
    @Override
    public Set<String> extract(String input) {
        Set<String> result = new HashSet<>();

        String regex = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }
}
