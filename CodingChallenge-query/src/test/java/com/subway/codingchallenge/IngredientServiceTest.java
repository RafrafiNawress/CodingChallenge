package com.subway.codingchallenge;

import static org.mockito.Mockito.*;

import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.repositories.IngredientRepository;
import com.subway.codingchallenge.services.IngredientServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class IngredientServiceTest {



    @MockBean
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;
    @Test
    public void testGetAllIngredients() throws Exception {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(1L, "Ingredient1", 10.0, 100, "Type1"),
                new Ingredient(2L, "Ingredient2", 20.0, 200, "Type2"),
                new Ingredient(3L, "Ingredient3", 30.0, 300, "Type3")
        );
        when(ingredientRepository.findAll()).thenReturn(mockIngredients);

        List<Ingredient> result = ingredientService.getAllIngredients();
        Assertions.assertThat(result).isEqualTo(mockIngredients);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isGreaterThan(1);

    }


}
