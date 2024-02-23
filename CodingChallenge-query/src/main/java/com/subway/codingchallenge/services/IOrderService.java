package com.subway.codingchallenge.services;

import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.entities.Order;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface IOrderService {

    public Order add(Order order);
    Order update(Order order);
    boolean delete(long idOrder);
    Page<OrderDto> getOrders(int pageNbr, int pageSize);




}
