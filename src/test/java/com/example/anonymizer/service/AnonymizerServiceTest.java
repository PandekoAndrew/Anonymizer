package com.example.anonymizer.service;

import com.example.anonymizer.AbstactTest;
import com.example.anonymizer.model.Anonymizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AnonymizerServiceTest extends AbstactTest {
    private AnonymizerService anonymizerService;

    private List<Anonymizer> anonymizers;

    @BeforeEach
    void setUp() {
        Anonymizer a1 = mock(Anonymizer.class);
        Anonymizer a2 = mock(Anonymizer.class);
        anonymizers = List.of(a1, a2);
        anonymizerService = new AnonymizerService(anonymizers);
    }

    @Test
    void anonymize() {
        for (Anonymizer a : anonymizers) {
            when(a.anonymize(INPUT)).thenReturn(INPUT);
        }
        String result = anonymizerService.anonymize(INPUT);
        for (Anonymizer a : anonymizers) {
            verify(a, times(1)).anonymize(INPUT);
        }
        assertEquals(INPUT, result);
    }
}