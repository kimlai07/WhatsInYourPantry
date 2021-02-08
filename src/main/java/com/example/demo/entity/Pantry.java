package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
public class Pantry {
    private String pantryName;
    private String description;
    private UUID userId;
    private UUID pantryId;

    public Pantry(){
        pantryId = UUID.randomUUID();
    }
}
