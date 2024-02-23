package com.subway.codingchallenge.events;

import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventHandler {
    private final IOrderService orderService;

    public void handleOrderCreatedEvent(OrderDto orderDto) {
        orderService.add(OrderDto.mapToOrder(orderDto));
    }

    public void handleOrderUpdatedEvent(OrderDto orderDto) {
        orderService.update(OrderDto.mapToOrder(orderDto));
    }

    public void handleOrderDeletedEvent(long idProduct) {
        orderService.delete(idProduct);
    }
}
