package com.subway.codingchallenge.services;

import com.subway.codingchallenge.entities.Ingredient;

import java.util.List;

public interface IIngredientService {

    public List<Ingredient> getAllIngredients();
    public Ingredient getIngredientById(Long id);
}
