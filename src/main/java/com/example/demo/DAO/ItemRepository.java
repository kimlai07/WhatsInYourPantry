package com.example.demo.DAO;

import com.example.demo.entity.Pantry;
import com.example.demo.entity.PantryItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class ItemRepository {
    HashMap<UUID, ArrayList<PantryItem>> userPantryItemMap;
    public ArrayList<PantryItem> findPantryItemsByPantryId(UUID pantryId) {
        ArrayList<PantryItem> pantryItems = userPantryItemMap.get(pantryId);
        return pantryItems;
    }
    public ItemRepository(){
        userPantryItemMap = new HashMap<>();
    }

    public void createPantryItem(PantryItem newPantryItem) {
        ArrayList<PantryItem> pantryItems = findPantryItemsByPantryId(newPantryItem.getPantryId());
        if(pantryItems!= null){
            pantryItems.add(newPantryItem);
        }
        else {
            pantryItems = new ArrayList<>();
            pantryItems.add(newPantryItem);
            userPantryItemMap.put(newPantryItem.getPantryId(), pantryItems);
        }
    }
}
