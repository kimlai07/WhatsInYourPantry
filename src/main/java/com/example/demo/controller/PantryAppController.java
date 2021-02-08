package com.example.demo.controller;


import com.example.demo.Request.CreateItemRequest;
import com.example.demo.Request.CreatePantryRequest;
import com.example.demo.Request.CreateUserRequest;
import com.example.demo.entity.Pantry;
import com.example.demo.entity.PantryItem;
import com.example.demo.entity.User;
import com.example.demo.service.ItemService;
import com.example.demo.service.PantryService;
import com.example.demo.service.UserService;
import com.example.demo.vo.PantryUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/user")
public class PantryAppController {

    @Autowired
    UserService userService;
    @Autowired
    PantryService pantryService;
    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public PantryUserResponse getUser(@PathVariable("id") UUID userId){
        System.out.println(userId);
        return userService.getUserById(userId);
    }
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody CreateUserRequest createUserRequest){
        System.out.println(createUserRequest);
        return userService.createUser(createUserRequest);
    }

    @PostMapping(path = "/{id}/pantry", consumes = "application/json", produces = "application/json")
    public Pantry createUser(@PathVariable("id") UUID userId, @RequestBody CreatePantryRequest createPantryRequest){
        createPantryRequest.setUserId(userId);
        return pantryService.createPantry(createPantryRequest);
    }
    @PostMapping(path = "/{id}/pantry/{pantryId}", consumes = "application/json", produces = "application/json")
    public PantryItem createPantryItem(@PathVariable("pantryId") UUID pantryId, @RequestBody CreateItemRequest createItemRequest){
        createItemRequest.setPantryId(pantryId);
        return itemService.createPantryItem(createItemRequest);
    }
}
