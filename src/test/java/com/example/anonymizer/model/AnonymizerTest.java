package com.example.anonymizer.model;

import com.example.anonymizer.AbstactTest;
import com.example.anonymizer.extractor.Extractor;
import com.example.anonymizer.generator.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class AnonymizerTest extends AbstactTest {

    private Anonymizer anonymizer;

    private Extractor extractor;

    private Generator generator;

    @BeforeEach
    void setUp() {
        extractor = mock(Extractor.class);
        generator = mock(Generator.class);
        anonymizer = new Anonymizer(extractor, generator);
    }

    @Test
    void anonymize() {
        when(extractor.extract(anyString())).thenReturn(Set.of("Andrei"));
        when(generator.generate()).thenReturn("Amber");
        String result = anonymizer.anonymize(INPUT);
        verify(generator, times(1)).generate();
        verify(extractor, times(1)).extract(anyString());
        assertEquals("Hello, my name is Amber Pandeko. I'm working in iTechArt. pandzeka.andrei@itechart-group.com. 12345678. https://google.com", result);
    }
}