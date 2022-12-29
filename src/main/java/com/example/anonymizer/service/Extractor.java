package com.example.anonymizer.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Extractor {

    public Set<String> extractIDs(String input) {
        Set<String> result = new HashSet<>();

        String regex = "\\d{4,}";

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }

    public Set<String> extractEmails(String input) {
        Set<String> result = new HashSet<>();

        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }

    public Set<String> extractURLs(String input) {
        Set<String> result = new HashSet<>();

        String regex = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";

        Matcher m = Pattern.compile(regex).matcher(input);

        while (m.find()) {
            result.add(m.group());
        }

        return result;
    }

    public Set<String> extractNames(String input) {
        Set<String> result = new HashSet<>();


        return result;
    }
}
