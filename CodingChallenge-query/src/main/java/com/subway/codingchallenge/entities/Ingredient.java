package com.subway.codingchallenge.entities;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    Long id;
    String name;
    double price;
    int availableQuantity;
    String type;
}
