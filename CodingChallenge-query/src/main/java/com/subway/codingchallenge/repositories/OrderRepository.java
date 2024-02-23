package com.subway.codingchallenge.repositories;

import com.subway.codingchallenge.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
}
