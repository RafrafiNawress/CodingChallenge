package com.subway.codingchallenge.repositories;

import com.subway.codingchallenge.entities.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, Long> {
}
