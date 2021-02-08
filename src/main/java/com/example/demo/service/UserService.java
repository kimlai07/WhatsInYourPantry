package com.example.demo.service;

import com.example.demo.DAO.ItemRepository;
import com.example.demo.DAO.PantryRepository;
import com.example.demo.DAO.UserRepository;
import com.example.demo.Request.CreateUserRequest;
import com.example.demo.entity.Pantry;
import com.example.demo.entity.PantryItem;
import com.example.demo.entity.User;
import com.example.demo.vo.PantryItems;
import com.example.demo.vo.PantryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PantryRepository pantryRepository;

    @Autowired
    ItemRepository itemRepository;

    public User createUser(CreateUserRequest createUserRequest) {
        User newUser = new User();
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setFirstName(createUserRequest.getFirstName());
        newUser.setLastName(createUserRequest.getLastName());
        userRepository.saveUser(newUser);
        log.info("New user: {}", newUser);
        return newUser;
    }

    public PantryUserResponse getUserById(UUID userId) {
        PantryUserResponse pantryUserResponse = new PantryUserResponse();
        try {
            User user = userRepository.getUserById(userId);
            List<Pantry> pantries = pantryRepository.findPantriesByUserId(userId);
            List<PantryItems> pantryWithItems = new ArrayList<>();

            if (pantries != null) {
                pantries.forEach(pantry -> {
                    ArrayList<PantryItem> itemsInPantry = itemRepository.findPantryItemsByPantryId(pantry.getPantryId());
                    PantryItems currentPantryItems = new PantryItems();
                    currentPantryItems.setDescription(pantry.getDescription());
                    currentPantryItems.setPantryId(pantry.getPantryId());
                    currentPantryItems.setPantryName(pantry.getPantryName());
                    currentPantryItems.setPantryItems(itemsInPantry);
                    pantryWithItems.add(currentPantryItems);
                });
            }

            pantryUserResponse.setUserPantries(pantryWithItems);
            pantryUserResponse.setFirstName(user.getFirstName());
            pantryUserResponse.setLastName(user.getLastName());
            pantryUserResponse.setEmail(user.getEmail());
            pantryUserResponse.setUserId(user.getUuid());

            return pantryUserResponse;
        } catch (Exception e) {
            log.error("User is null");
        }
        return null;
    }
}
