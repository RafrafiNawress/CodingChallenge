package com.subway.codingchallenge.controller;


import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.services.IIngredientService;
import com.subway.codingchallenge.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientRestController {

    private final IIngredientService ingredientService;


    @PreAuthorize("hasRole('USER')")
    @GetMapping()
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }


}
