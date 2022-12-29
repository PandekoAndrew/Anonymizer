package com.example.anonymizer.model;

import lombok.Getter;

@Getter
public class OutputDTO {
    private final String output;

    public OutputDTO(String output) {
        this.output = output;
    }
}
