package com.example.anonymizer;

import java.util.Map;
import java.util.Set;

public abstract class AbstactTest {
    protected static String INPUT = "Hello, my name is Andrei Pandeko. I'm working in iTechArt. pandzeka.andrei@itechart-group.com. 12345678. https://google.com";
    protected static Map<String, Set<String>> RECOGNIZED_NAMES = Map.of(
            "fname", Set.of("Lior", "Alex", "Andrei", "John", "Dr. Amber"),
            "lname", Set.of("Harel", "Yakovlev", "Pandeko", "Doe"),
            "company", Set.of("Staircase", "iTechArt", "Google", "Amazon"));
}
