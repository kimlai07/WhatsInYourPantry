package com.example.demo.vo;

import com.example.demo.entity.PantryItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;
@Data
public class PantryItems {
    private String pantryName;
    private String description;
    private UUID pantryId;
    ArrayList<PantryItem> pantryItems;
}
