package com.subway.codingchallenge.repositories;

import com.subway.codingchallenge.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
