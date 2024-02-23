package com.subway.codingchallenge;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.entities.Order;
import com.subway.codingchallenge.repositories.OrderRepository;
import com.subway.codingchallenge.services.IOrderServiceImp;
import com.subway.codingchallenge.services.IngredientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CodingChallengeApplicationTests {
	@MockBean
	private IngredientServiceImpl ingredientService;

	@MockBean
	OrderRepository orderRepository;

	@Autowired
	IOrderServiceImp orderService;
	@Test
	public void testAddOrder() throws Exception {

		Order order = new Order();
		when(ingredientService.getIngredientById(any(Long.class))).thenReturn(new Ingredient(1L, "Ingredient1", 10.0, 100, "Type1"));
		when(orderRepository.save(any(Order.class))).thenReturn(new Order());

		OrderDto result = orderService.add(OrderDto.mapToOrderDto(order));
		verify(orderRepository).save(any(Order.class));
	}

}
