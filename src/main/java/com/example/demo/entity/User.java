package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private UUID uuid;

    public User(){
        uuid = UUID.randomUUID();
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        uuid = UUID.randomUUID();
    }
}
