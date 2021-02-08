package com.example.demo.DAO;

import com.example.demo.entity.Pantry;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class PantryRepository {
    HashMap<UUID, ArrayList<Pantry>> userPantryMap;
    public ArrayList<Pantry> findPantriesByUserId(UUID userId) {
        ArrayList<Pantry> pantries = userPantryMap.get(userId);
        return pantries;
    }
    public PantryRepository(){
        userPantryMap = new HashMap<>();
    }

    public void createPantry(Pantry newPantry) {
        ArrayList<Pantry> userPantries = findPantriesByUserId(newPantry.getUserId());
        if(userPantries!= null){
            userPantries.add(newPantry);
        }
        else {
            userPantries = new ArrayList<>();
            userPantries.add(newPantry);
            userPantryMap.put(newPantry.getUserId(), userPantries);
        }
    }
}
