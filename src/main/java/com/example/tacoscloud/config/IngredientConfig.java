package com.example.tacoscloud.config;

import com.example.tacoscloud.entities.Ingredient;
import com.example.tacoscloud.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class IngredientConfig {

    @Bean
    CommandLineRunner commandLineRunner(IngredientRepository ingredientRepository){
        return args -> {
            Ingredient ingredient1 = new Ingredient();
            ingredient1.setId("FLTO");
            ingredient1.setName("Flour Tortilla");
            ingredient1.setType(Ingredient.Type.WRAP);

            Ingredient ingredient2 = new Ingredient();
            ingredient2.setId("COTO");
            ingredient2.setName("Corn Tortilla");
            ingredient2.setType(Ingredient.Type.WRAP);

            Ingredient ingredient3 = new Ingredient();
            ingredient3.setId("GRBF");
            ingredient3.setName("Ground Beef");
            ingredient3.setType(Ingredient.Type.PROTEIN);

            Ingredient ingredient4 = new Ingredient();
            ingredient4.setId("CARN");
            ingredient4.setName("Carnitas");
            ingredient4.setType(Ingredient.Type.PROTEIN);

            Ingredient ingredient5 = new Ingredient();
            ingredient5.setId("TMTO");
            ingredient5.setName("Diced Tomatoes");
            ingredient5.setType(Ingredient.Type.VEGGIES);

            Ingredient ingredient6 = new Ingredient();
            ingredient6.setId("LETC");
            ingredient6.setName("Lettuce");
            ingredient6.setType(Ingredient.Type.VEGGIES);

            Ingredient ingredient7 = new Ingredient();
            ingredient7.setId("CHED");
            ingredient7.setName("Cheddar");
            ingredient7.setType(Ingredient.Type.CHEESE);

            Ingredient ingredient8 = new Ingredient();
            ingredient8.setId("JACK");
            ingredient8.setName("Monterrey Jack");
            ingredient8.setType(Ingredient.Type.CHEESE);

            Ingredient ingredient9 = new Ingredient();
            ingredient9.setId("SLSA");
            ingredient9.setName("Salsa");
            ingredient9.setType(Ingredient.Type.SAUCE);

            Ingredient ingredient10 = new Ingredient();
            ingredient10.setId("SRCR");
            ingredient10.setName("Sour Cream");
            ingredient10.setType(Ingredient.Type.SAUCE);

            ingredientRepository.saveAll(
                    List.of(  ingredient1, ingredient2, ingredient3
                            , ingredient4, ingredient5, ingredient6
                            , ingredient7, ingredient8, ingredient9
                            , ingredient10)
            );
        };
    }


}
