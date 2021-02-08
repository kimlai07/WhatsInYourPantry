package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;
@Data
public class PantryItem {

    private String name;
    private String description;
    private Long quantity;
    private UUID pantryId;
    private UUID id;
    public PantryItem(){
        id = UUID.randomUUID();
    }
}
