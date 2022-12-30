package com.example.anonymizer.extractor;

import com.example.anonymizer.AbstactTest;
import com.example.anonymizer.service.NameRecognizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FirstNameExtractorTest extends AbstactTest {
    private FirstNameExtractor extractor;

    private NameRecognizer nameRecognizer;

    @BeforeEach
    void setUp() {
        nameRecognizer = mock(NameRecognizer.class);
        extractor = new FirstNameExtractor(nameRecognizer);
    }

    @Test
    void extract() {
        when(nameRecognizer.recognizeNames(Mockito.anyString())).thenReturn(RECOGNIZED_NAMES);
        Set<String> result = extractor.extract(INPUT);
        verify(nameRecognizer, times(1)).recognizeNames(INPUT);
        assertEquals(RECOGNIZED_NAMES.get("fname"), result);
    }

    @Test
    void TestExtractNullPointer() {
        when(nameRecognizer.recognizeNames(Mockito.anyString())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            extractor.extract(INPUT);
        });
    }
}