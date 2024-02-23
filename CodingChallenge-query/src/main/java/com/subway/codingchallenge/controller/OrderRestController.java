package com.subway.codingchallenge.controller;


import com.subway.codingchallenge.dto.OrderDto;
import com.subway.codingchallenge.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final IOrderService orderService;

    @GetMapping
    public Page<OrderDto> getOrders(int pageNbr, int pageSize){
        return orderService.getOrders(pageNbr,pageSize);
    }

}
