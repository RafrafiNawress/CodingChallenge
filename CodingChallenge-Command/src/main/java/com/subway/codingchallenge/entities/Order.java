package com.subway.codingchallenge.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order_table")
@Data
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double totalCost;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToMany
    List<Ingredient> ingredients;


}
