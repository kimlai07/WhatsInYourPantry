package com.example.demo.Request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateItemRequest {
    private String name;
    private String description;
    private Long quantity;
    private UUID pantryId;
}
