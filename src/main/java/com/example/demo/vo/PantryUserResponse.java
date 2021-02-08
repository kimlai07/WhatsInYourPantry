package com.example.demo.vo;

import com.example.demo.entity.Pantry;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
public class PantryUserResponse {
    String firstName;
    String lastName;
    String email;
    UUID userId;
    List<PantryItems> userPantries;
}
