package com.subway.codingchallenge.dto;

import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.entities.Order;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderDto(long id, double totalcost, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Ingredient> ingredients) {
    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(orderDto.id(), orderDto.totalcost(), orderDto.createdAt(), orderDto.updatedAt(), orderDto.ingredients);
    }
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(order.getId(),order.getTotalCost(), order.getCreatedAt(), order.getUpdatedAt(), order.getIngredients());
    }
}
