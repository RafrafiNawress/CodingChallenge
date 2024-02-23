package com.subway.codingchallenge.services;

import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.repositories.IngredientRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    @PostConstruct
    public void initializeEmployeeTable() {
        ingredientRepository.saveAll(
                Stream.of(
                        new Ingredient(1L,"ing1", 2000, 10, "meat"),
                        new Ingredient(2L,"ing2", 2500, 10, "vegetable,"),
                        new Ingredient(3L,"ing3", 3000, 10, "cheese,")
                ).collect(Collectors.toList()));

    }


}
