package com.example.demo.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePantryRequest {
    private String pantryName;
    private String description;
    private  UUID userId;

    @Override
    public String toString() {
        return "CreatePantryRequest{" +
                "pantryName='" + pantryName + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
