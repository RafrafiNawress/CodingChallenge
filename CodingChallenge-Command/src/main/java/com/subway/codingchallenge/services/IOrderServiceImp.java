package com.subway.codingchallenge.services;

import com.subway.codingchallenge.dto.Event;
import com.subway.codingchallenge.dto.EventType;
import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.entities.Order;
import com.subway.codingchallenge.events.KafkaProducer;
import com.subway.codingchallenge.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IOrderServiceImp implements IOrderService {


    private final OrderRepository orderRepository;
    private final KafkaProducer kafkaProducer;
    private final IIngredientService ingredientService;



    @Override
    public OrderDto add(OrderDto orderDto) {
        Order order = OrderDto.mapToOrder(orderDto);
        order.setCreatedAt(LocalDateTime.now());
        double totalCost = calculateTotalCost((List<Ingredient>) orderDto.ingredients());
        order.setTotalCost( totalCost);
        orderDto = OrderDto.mapToOrderDto(orderRepository.save(order));
        kafkaProducer.produceEvent(new Event(EventType.CREATED_ORDER_EVENT, orderDto,LocalDateTime.now()));
        return orderDto;
    }

    private double calculateTotalCost(List<Ingredient> ingredients) {
        double totalCost = 0.0;
        for (Ingredient ingredient : ingredients) {
            Ingredient ingredientById = ingredientService.getIngredientById(ingredient.getId());
            double ingredientCost = ingredientById.getPrice() * ingredient.getAvailableQuantity();
            totalCost += ingredientCost;
        }
        totalCost *= 1.3;
        return totalCost;
    }


    @Override
    public OrderDto update(long idProduct, Map<Object, Object> fields) {
        return null;
    }

    @Override
    public boolean delete(long idOrder) {
        return false;
    }


}
