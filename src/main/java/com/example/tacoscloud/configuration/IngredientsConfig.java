package com.example.tacoscloud.configuration;

import com.example.tacoscloud.entities.Ingredient;
import com.example.tacoscloud.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class IngredientsConfig  {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository){
        return args -> {
            Ingredient ingredient1 = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
            Ingredient ingredient2 = new Ingredient("COTO", "Corn Tortilla'", Ingredient.Type.WRAP);
            Ingredient ingredient3 = new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
            Ingredient ingredient4 = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
            Ingredient ingredient5 = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
            Ingredient ingredient6 = new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES);
            Ingredient ingredient7 = new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE);
            Ingredient ingredient8 = new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
            Ingredient ingredient9 = new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE);
            Ingredient ingredient10 = new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE);

            ingredientRepository.saveAll(
                    List.of(  ingredient1, ingredient2, ingredient3
                            , ingredient4, ingredient5, ingredient6
                            , ingredient7, ingredient8, ingredient9
                            , ingredient10)
            );
        };
    }


}
