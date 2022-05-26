package com.example.tacoscloud.entities;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredientList;
}
