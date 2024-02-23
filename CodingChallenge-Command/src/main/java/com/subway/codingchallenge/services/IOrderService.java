package com.subway.codingchallenge.services;

import com.subway.codingchallenge.dto.OrderDto;

import java.util.Map;

public interface IOrderService {

    OrderDto add(OrderDto orderDto);

    OrderDto update(long idProduct, Map<Object,Object> fields);

    boolean delete(long idOrder);


}
