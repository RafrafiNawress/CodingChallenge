package com.subway.codingchallenge.services;

import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.entities.Ingredient;
import com.subway.codingchallenge.entities.Order;
import com.subway.codingchallenge.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IOrderServiceImp implements IOrderService {


    private final OrderRepository orderRepository;
    private final IIngredientService ingredientService;



    @Override
    public Order add(Order order) {
        order.setCreatedAt(LocalDateTime.now());
       /* double totalCost = calculateTotalCost((List<Ingredient>) order.ingredients());
        order.setTotalCost( totalCost);*/
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean delete(long idOrder) {
        orderRepository.deleteById(idOrder);
        return orderRepository.existsById(idOrder);
    }

    @Override
    public Page<OrderDto> getOrders(int pageNbr, int pageSize) {
        return orderRepository.findAll(PageRequest.of(pageNbr,pageSize)).map(OrderDto::mapToOrderDto);
    }




}
