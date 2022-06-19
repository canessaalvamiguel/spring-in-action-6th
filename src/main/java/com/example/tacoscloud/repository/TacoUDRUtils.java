package com.example.tacoscloud.repository;

import com.example.tacoscloud.entities.Ingredient;
import com.example.tacoscloud.entities.IngredientUDT;

public class TacoUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
