package com.subway.codingchallenge.services;

import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IIngredientService {

        private final IngredientRepository ingredientRepository;

        @Override
        public Ingredient getIngredientById(Long id) {
            return ingredientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Ingredient with id " + id + " not found"));
        }

        @Override
        public List<Ingredient> getAllIngredients() {
            return ingredientRepository.findAll();
        }



}
