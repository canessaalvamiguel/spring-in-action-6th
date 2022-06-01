package com.example.tacoscloud.controller;

import com.example.tacoscloud.entities.Ingredient;
import com.example.tacoscloud.entities.Taco;
import com.example.tacoscloud.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.tacoscloud.entities.Ingredient.Type;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesingForm(Model model){
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors, RedirectAttributes redirectAttributes){
        if(errors.hasErrors()){
            return "design";
        }
        redirectAttributes.addFlashAttribute("taco", taco);

        log.info("Processing taco: " +taco);
        return "redirect:/orders/current";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = convertIterableToList(ingredientRepo.findAll());

        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    private <T> List<T> convertIterableToList(Iterable<T> iterable){
        List<T> ingredientList = new ArrayList<>();
        iterable.forEach(ingredientList::add);
        return ingredientList;
    }
}
