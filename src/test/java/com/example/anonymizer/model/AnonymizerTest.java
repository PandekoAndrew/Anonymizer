package com.example.anonymizer.model;

import com.example.anonymizer.AbstactTest;
import com.example.anonymizer.extractor.Extractor;
import com.example.anonymizer.generator.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void testAnonymizeSuccess() {
        String expected = INPUT.replace("Andrei", "Amber");
        when(extractor.extract(anyString())).thenReturn(Set.of("Andrei"));
        when(generator.generate()).thenReturn("Amber");
        String result = anonymizer.anonymize(INPUT);
        verify(generator, times(1)).generate();
        verify(extractor, times(1)).extract(anyString());
        assertEquals(expected, result);
    }

    @Test
    void testAnonymizeNullPointer() {
        when(extractor.extract(anyString())).thenReturn(null);
        when(generator.generate()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> {
            anonymizer.anonymize(INPUT);
        });
    }
}