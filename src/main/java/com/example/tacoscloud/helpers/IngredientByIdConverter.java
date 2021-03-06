package com.example.tacoscloud.helpers;

import com.example.tacoscloud.entities.Ingredient;
import com.example.tacoscloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        Ingredient ingredient = ingredientRepo.findById(id).orElse(null);
        return new Ingredient(id, ingredient.getName(), ingredient.getType());
    }
}
