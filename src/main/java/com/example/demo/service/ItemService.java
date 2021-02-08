package com.example.demo.service;

import com.example.demo.DAO.ItemRepository;
import com.example.demo.DAO.PantryRepository;
import com.example.demo.Request.CreateItemRequest;
import com.example.demo.Request.CreatePantryRequest;
import com.example.demo.entity.Pantry;
import com.example.demo.entity.PantryItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public PantryItem createPantryItem(CreateItemRequest createItemRequest) {
        PantryItem newPantryItem = new PantryItem();
        newPantryItem.setDescription(createItemRequest.getDescription());
        newPantryItem.setName(createItemRequest.getName());
        newPantryItem.setPantryId(createItemRequest.getPantryId());
        newPantryItem.setQuantity(createItemRequest.getQuantity());
        itemRepository.createPantryItem(newPantryItem);
        return newPantryItem;
    }
}
