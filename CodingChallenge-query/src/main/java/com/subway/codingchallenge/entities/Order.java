package com.subway.codingchallenge.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Set;

@Document
@Data
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @Setter(AccessLevel.NONE)
    Long id;
    double totalCost;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Set<Ingredient> ingredients;
}
