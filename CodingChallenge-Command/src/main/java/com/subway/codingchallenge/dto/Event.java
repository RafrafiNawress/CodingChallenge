package com.subway.codingchallenge.dto;

import java.time.LocalDateTime;

public record Event(EventType type, OrderDto orderDto, LocalDateTime eventCreatedAt){}
