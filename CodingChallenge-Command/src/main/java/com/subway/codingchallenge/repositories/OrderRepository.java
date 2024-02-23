package com.subway.codingchallenge.repositories;

import com.subway.codingchallenge.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
