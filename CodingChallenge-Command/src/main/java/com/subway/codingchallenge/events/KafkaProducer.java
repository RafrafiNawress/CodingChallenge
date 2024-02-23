package com.subway.codingchallenge.events;

import com.subway.codingchallenge.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {


    private final KafkaTemplate<String, Event> kafkaTemplate;
    private String topic = "order-event-topic";

    public void produceEvent(Event orderEvent) {
        kafkaTemplate.send(this.topic, orderEvent.type().toString() , orderEvent);
    }

}
