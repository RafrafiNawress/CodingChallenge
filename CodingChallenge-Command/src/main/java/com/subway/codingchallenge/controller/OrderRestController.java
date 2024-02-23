package com.subway.codingchallenge.controller;


import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final IOrderService orderService;

    @Secured("ROLE_ADMIN")
    @PostMapping
    public OrderDto placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.add(orderDto);
    }

}
