package com.example.demo.service;

import com.example.demo.DAO.PantryRepository;
import com.example.demo.Request.CreatePantryRequest;
import com.example.demo.entity.Pantry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PantryService {
    @Autowired
    PantryRepository pantryRepository;
    public Pantry createPantry(CreatePantryRequest createPantryRequest) {
        Pantry newPantry = new Pantry();
        newPantry.setDescription(createPantryRequest.getDescription());
        newPantry.setPantryName(createPantryRequest.getPantryName());
        newPantry.setUserId(createPantryRequest.getUserId());
        pantryRepository.createPantry(newPantry);
        return newPantry;
    }
}
